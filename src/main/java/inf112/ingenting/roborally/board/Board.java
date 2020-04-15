package inf112.ingenting.roborally.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.element.Flag;
import inf112.ingenting.roborally.player.Robot;
import inf112.ingenting.roborally.player.RobotDirection;

import java.util.*;

public class Board implements IBoard {
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;

	enum LayerType { FLOOR, WALL, PLAYER_START, INTERACTABLE }
	private Map<LayerType, TiledMapTileLayer> layers;

	private static Array<Flag> flags;

	private Array<Robot> robots;

	public Board(String fileName, float unitScale, OrthographicCamera camera) {
		map = new TmxMapLoader().load(fileName);
		layers = createLayers();

		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);
		mapRenderer.setView(camera);

		this.robots = new Array<>();
		Board.flags = createFlagsFromMap();
	}

	public Board(String fileName, float unitScale, OrthographicCamera camera, Array<Robot> robots) {
		map = new TmxMapLoader().load(fileName);

		layers = createLayers();

		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);
		mapRenderer.setView(camera);

		this.robots = robots;
	}

	public Board() {
		this.robots = new Array<>();
	}

	// Constructor helpers
	private Map<LayerType, TiledMapTileLayer> createLayers() {
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
			robot.render(batch);
		}
		batch.end();
	}

	// Check tile stuff
	public void checkTile(Robot robot) {
		TiledMapTileLayer.Cell cell = layers.get(LayerType.INTERACTABLE).getCell((int) robot.getPosition().x,(int) robot.getPosition().y);
		if (cell == null)
			return;

		MapProperties tileProperties = cell.getTile().getProperties();

		switch ((String) tileProperties.get("type")) {
			case "hole":
				robot.setAlive(false);
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
							robot.setRelativePosition(0, 1);
							break;
						case SOUTH:
							robot.setRelativePosition(0, -1);
							break;
						case EAST:
							robot.setRelativePosition(1, 0);
							break;
						case WEST:
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
							robot.setRelativePosition(0, -1);
							break;
						case SOUTH:
							robot.setRelativePosition(0, 1);
							break;
						case EAST:
							robot.setRelativePosition(-1, 0);
							break;
						case WEST:
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
