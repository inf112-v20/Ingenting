package inf112.ingenting.roborally.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.element.Flag;
import inf112.ingenting.roborally.player.Robot;
import inf112.ingenting.roborally.player.RobotDirection;

import java.util.*;

public class Board implements IBoard {
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	private AssetManager assetManager;

	enum LayerType { FLOOR, WALL, PLAYER_START, INTERACTABLE }
	private Map<LayerType, TiledMapTileLayer> layers;

	private static Array<Flag> flags;

	private Array<Robot> robots = new Array<>();

	/**
	 * Default constructor for board.
	 *
	 * @param assetManager	The asset manager to use for map loading.
	 * @param fileName		The file path for the map.
	 * @param camera		The camera to use for rendering.
	 */
	public Board(AssetManager assetManager, String fileName, OrthographicCamera camera) {
		this.assetManager = assetManager;
		this.assetManager.load(fileName, TiledMap.class);
		this.assetManager.finishLoadingAsset(fileName);
		this.map = assetManager.get(fileName);
		this.layers = createLayersFromMap();

		MapProperties properties = map.getProperties();

		float unitScale;
		if (properties.get("orientation").equals("orthogonal"))
			unitScale = (int) properties.get("tilewidth");
		else
			unitScale = Math.min((float) properties.get("tilewidth"), (float) properties.get("tileheight"));

		camera.setToOrtho(
				false,
				layers.get(LayerType.FLOOR).getWidth() * 2,
				layers.get(LayerType.FLOOR).getHeight()
		);
		this.mapRenderer = new OrthogonalTiledMapRenderer(map, (float) 1 / unitScale);
		this.mapRenderer.setView(camera);

		Board.flags = createFlagsFromMap();
	}

	/**
	 * Constructor that does not initialize rendering.
	 *
	 * @param assetManager	The asset manager to use for map loading.
	 * @param fileName		The file path for the map.
	 */
	public Board(AssetManager assetManager, String fileName) {
		this.assetManager = assetManager;
		this.assetManager.load(fileName, TiledMap.class);
		this.assetManager.finishLoadingAsset(fileName);
		this.map = assetManager.get(fileName);
		this.layers = createLayersFromMap();

		Board.flags = createFlagsFromMap();
	}

	// Constructor helpers
	private Map<LayerType, TiledMapTileLayer> createLayersFromMap() {
		Map<LayerType, TiledMapTileLayer> layers = new HashMap<>();

		for (LayerType type : LayerType.values())
			layers.put(type, (TiledMapTileLayer) map.getLayers().get(type.name().toLowerCase()));

		return layers;
	}

	private Array<Flag> createFlagsFromMap() {
		Array<Flag> flags = new Array<>();

		for (int y = 0; y < layers.get(LayerType.FLOOR).getHeight(); y++) {
			for (int x = 0; x < layers.get(LayerType.FLOOR).getWidth(); x++) {
				TiledMapTileLayer.Cell cell = layers.get(LayerType.INTERACTABLE).getCell(x, y);
				if (cell == null)
					continue;

				TiledMapTile tile = cell.getTile();
				if (tile.getProperties().get("type").equals("flag")) {
					Flag flag = new Flag(x, y, (int) tile.getProperties().get("value"));

					flags.add(flag);
				}
			}
		}

		// Sort flags by level
		flags.sort(Comparator.comparingInt(Flag::getLevel));
		return flags;
	}

	// Rendering
	@Override
	public void render() {
		renderTileMap();
		renderRobots();
	}

	public void renderTileMap() {
		mapRenderer.render();
	}

	public void renderRobots() {
		Batch batch = mapRenderer.getBatch();

		batch.begin();
		for (Robot robot : robots) {
			robot.render(batch, assetManager);
		}
		batch.end();
	}

	public String getProperty(Vector2 position, String property) {
		TiledMapTileLayer.Cell cell = layers.get(LayerType.INTERACTABLE).getCell((int) position.x, (int)position.y);
		if (cell == null)
			return "null";
		MapProperties tileProperties = cell.getTile().getProperties();
		return (String) tileProperties.get(property);
	}

	// Check tile stuff
	public void checkTile(Robot robot) {
		TiledMapTileLayer.Cell cell = layers.get(LayerType.INTERACTABLE).getCell((int) robot.getPosition().x,(int) robot.getPosition().y);
		if (cell == null)
			return;

		MapProperties tileProperties = cell.getTile().getProperties();

		switch ((String) tileProperties.get("type")) {
			case "hole":
				robot.setActive(false);
				break;

			case "repair":
				if ((boolean) tileProperties.get("doubleRepair"))
					robot.setRelativeHP(2);
				else
					robot.setRelativeHP(1);
				break;

			case "laser":
				int count = (int) tileProperties.get("count");
				boolean cross = (boolean) tileProperties.get("cross");

				if (count == 1) {
					if (cross)
						robot.setRelativeHP(-2);
					else
						robot.setRelativeHP(-1);
				} else {
					if (cross)
						robot.setRelativeHP(-4);
					else
						robot.setRelativeHP(-2);
				}
				break;

			case "conveyor":
				int speed = (int) tileProperties.get("speed");

				switch ((String) tileProperties.get("direction")) {
					case "north":
						robot.setRelativePosition(0, speed);
						break;

					case "east":
						robot.setRelativePosition(speed, 0);
						break;

					case "south":
						robot.setRelativePosition(0, -speed);
						break;

					case "west":
						robot.setRelativePosition(-speed, 0);
						break;

					default:
						break;
				}
				break;
		}
	}

	private void checkFlag(Robot robot){
		for (Flag f : flags) {
			if (f.getXPosition() == robot.getPosition().x && f.getYPosition() == robot.getPosition().y) {
				if (f.getLevel() == robot.getCurrentGoal().getLevel()) {
					int newGoal = (robot.getCurrentGoal().getLevel() + 1) - 1;
					int index = newGoal >= flags.size ? flags.size - 1 : newGoal;
					robot.setCurrentGoal(flags.get(index));
					robot.setFlagsVisited(robot.getFlagsVisited() + 1);
				}
			}
		}
	}

	/**
	 * Collision checker
	 *
	 * @param robot			current robot.
	 * @param nextCell		the cell current robot tries to move to.
	 */
	private ArrayList<RobotDirection> moveBlock(Robot robot, TiledMapTileLayer.Cell nextCell) {
		ArrayList<RobotDirection> blockedDirection = new ArrayList<>();
		TiledMapTileLayer.Cell currentCell = layers.get(LayerType.WALL).getCell((int) robot.getPosition().x,(int) robot.getPosition().y);
		if (currentCell == null)
			return new ArrayList<>();

		MapProperties tileProperties = currentCell.getTile().getProperties();

		//TODO: Needs to check nextCell for walls.

		// Checking current cell for walls
		switch ((String) tileProperties.get("direction")) {
			case "west":
				blockedDirection.add(RobotDirection.WEST);
			case "north":
				blockedDirection.add(RobotDirection.NORTH);
			case "east":
				blockedDirection.add(RobotDirection.EAST);
			case "south":
				blockedDirection.add(RobotDirection.SOUTH);
			case "northwest":
				blockedDirection.add(RobotDirection.NORTH);
				blockedDirection.add(RobotDirection.WEST);
			case "southwest":
				blockedDirection.add(RobotDirection.SOUTH);
				blockedDirection.add(RobotDirection.WEST);
			case "southeast":
				blockedDirection.add(RobotDirection.SOUTH);
				blockedDirection.add(RobotDirection.EAST);
			case "northeast":
				blockedDirection.add(RobotDirection.NORTH);
				blockedDirection.add(RobotDirection.EAST);
		}
		return blockedDirection;
	}

	// Move
	private void moveRobot(Robot robot) {
		// If the robot does not have a programming card, return
		if (robot.getMove() == null)
			return;

		for (MoveType move : robot.getMove().getMoves()) {

			switch (move) {
				case FORWARD:
					switch (robot.getDirection()) {
						case NORTH:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x,(int) robot.getPosition().y+1)).contains(RobotDirection.NORTH))
								break;
							robot.setRelativePosition(0, 1);
							break;
						case SOUTH:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x,(int) robot.getPosition().y-1)).contains(RobotDirection.SOUTH))
								break;
							robot.setRelativePosition(0, -1);
							break;
						case EAST:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x+1,(int) robot.getPosition().y)).contains(RobotDirection.EAST))
								break;
							robot.setRelativePosition(1, 0);
							break;
						case WEST:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x-1,(int) robot.getPosition().y)).contains(RobotDirection.WEST))
								break;
							robot.setRelativePosition(-1, 0);
							break;
						default:
							break;
					}
					break;
				case ROTATE_LEFT:
					switch (robot.getDirection()) {
						case NORTH:
							robot.setDirection(RobotDirection.WEST);
							break;
						case SOUTH:
							robot.setDirection(RobotDirection.EAST);
							break;
						case EAST:
							robot.setDirection(RobotDirection.NORTH);
							break;
						case WEST:
							robot.setDirection(RobotDirection.SOUTH);
							break;
						default:
							break;
					}
					break;
				case ROTATE_RIGHT:
					switch (robot.getDirection()) {
						case NORTH:
							robot.setDirection(RobotDirection.EAST);
							break;
						case SOUTH:
							robot.setDirection(RobotDirection.WEST);
							break;
						case EAST:
							robot.setDirection(RobotDirection.SOUTH);
							break;
						case WEST:
							robot.setDirection(RobotDirection.NORTH);
							break;
						default:
							break;
					}
					break;
				case BACKUP:
					switch (robot.getDirection()) {
						case NORTH:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x,(int) robot.getPosition().y-1)).contains(RobotDirection.WEST))
								break;
							robot.setRelativePosition(0, -1);
							break;
						case SOUTH:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x,(int) robot.getPosition().y+1)).contains(RobotDirection.WEST))
								break;
							robot.setRelativePosition(0, 1);
							break;
						case EAST:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x-1,(int) robot.getPosition().y)).contains(RobotDirection.WEST))
								break;
							robot.setRelativePosition(-1, 0);
							break;
						case WEST:
							if (moveBlock(robot, layers.get(LayerType.WALL).getCell((int) robot.getPosition().x+1,(int) robot.getPosition().y)).contains(RobotDirection.WEST))
								break;
							robot.setRelativePosition(1, 0);
							break;
						default:
							break;
					}
					break;
				default:
					break;
			}
		}
		if (flags != null){
			checkFlag(robot);
		}
		checkTile(robot);
	}

	public void moveRobotKey(Robot robot) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			robot.setRelativePosition(0, 1);
			robot.setDirection(RobotDirection.NORTH);
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
			robot.setRelativePosition(1, 0);
			robot.setDirection(RobotDirection.EAST);
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			robot.setRelativePosition(-1, 0);
			robot.setDirection(RobotDirection.WEST);
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			robot.setRelativePosition(0, -1);
			robot.setDirection(RobotDirection.SOUTH);
		}

		checkFlag(robot);
		checkTile(robot);
	}

	@Override
	public void moveRobots() {
		PriorityQueue<Robot> robotMoveQueue = new PriorityQueue<>(Comparator.comparingInt(r -> r.getMove().getPriority()));

		for (Robot r : robots) {
			robotMoveQueue.add(r);
		}

		if (robotMoveQueue.size() == 0)
			return;

		moveRobot(robotMoveQueue.poll());
	}

	// LibGDX dispose
	public void dispose() {
		mapRenderer.dispose();
		map.dispose();

		for (Robot robot : robots) {
			robot.dispose();
		}
	}

	// Getters & Setters
	public static Flag[] getFlags() {
		return flags.toArray(Flag.class);
	}

	@Override
	public boolean addRobot(Robot robot) {
		for (Robot r : robots) {
			if (robot.getPosition() == r.getPosition())
				return false;
		}

		robots.add(robot);

		return true;
	}

	@Override
	public void removeRobot(int index) {
		robots.removeIndex(index);
	}

	public void clearRobots() {
		robots.clear();
	}

	public Robot getRobot(int index) {
		return robots.get(index);
	}

	@Override
	public boolean setRobot(int index, Robot robot) {
		for (Robot r : robots) {
			if (robot.getPosition() == r.getPosition())
				return false;
		}

		robots.set(index, robot);

		return true;
	}

	public Array<Robot> getRobots() {
		return robots;
	}

	public void setRobots(Array<Robot> robots) {
		this.robots = robots;
	}

}
