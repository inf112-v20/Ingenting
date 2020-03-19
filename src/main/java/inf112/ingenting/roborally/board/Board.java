package inf112.ingenting.roborally.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.player.Robot;
import inf112.ingenting.roborally.player.RobotDirection;

import java.util.PriorityQueue;

public class Board implements IBoard {
	public static final int LAYER_FLOOR = 0, LAYER_INTERACTABLE = 1;

	private TiledMap map;
	private TiledMapTileLayer[] layers;
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer mapRenderer;

	private Array<Robot> robots;

	public Board(String fileName, float unitScale, OrthographicCamera camera) {
		map = new TmxMapLoader().load(fileName);

		layers = new TiledMapTileLayer[] {
				(TiledMapTileLayer) map.getLayers().get("floor"),
				(TiledMapTileLayer) map.getLayers().get("interactable")
		};

		this.camera = camera;
		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);

		robots = new Array<>();
	}

	public Board(String fileName, float unitScale, OrthographicCamera camera, Array<Robot> robots) {
		map = new TmxMapLoader().load(fileName);

		layers = new TiledMapTileLayer[] {
				(TiledMapTileLayer) map.getLayers().get("floor"),
				(TiledMapTileLayer) map.getLayers().get("interactable")
		};

		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);
		mapRenderer.setView(camera);

		this.robots = robots;
	}

	public Board() {
		this.robots = new Array<>();
	}

	@Override
	public void render() {
		renderTileMap();
		renderRobots();
	}

	public void renderTileMap() {
		mapRenderer.setView(camera);
		mapRenderer.render();
	}

	public void renderTileMap(int layer) {
		mapRenderer.renderTileLayer(layers[layer]);
	}

	public void renderRobots() {
		Batch batch = mapRenderer.getBatch();

		batch.begin();
		for (Robot robot : robots) {
			robot.render(batch);
		}
		batch.end();
	}

	public Robot getRobot(int index) {
		return robots.get(index);
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
	public boolean setRobot(int index, Robot robot) {
		for (Robot r : robots) {
			if (robot.getPosition() == r.getPosition())
				return false;
		}

		robots.set(index, robot);

		return true;
	}

	@Override
	public void removeRobot(int index) {
		robots.removeIndex(index);
	}

	public Array<Robot> getRobots() {
		return robots;
	}

	public void setRobots(Array<Robot> robots) {
		this.robots = robots;
	}

	public boolean setTileCell(int x, int y, TiledMapTileLayer.Cell tile, int layer) {
		if (layer < 0 || layer > 1)
			return false;

		layers[layer].setCell(x, y, tile);

		return true;
	}

	public boolean setTileCell(int x, int y, TiledMapTileLayer.Cell[] tile) {
		if (tile.length != 2)
			return false;

		layers[0].setCell(x, y, tile[0]);
		layers[1].setCell(x, y, tile[1]);

		return true;
	}

	public TiledMapTileLayer.Cell[] getTileCells(int x, int y) {
		return new TiledMapTileLayer.Cell[] { layers[0].getCell(x, y), layers[1].getCell(x, y) };
	}

	public void dispose() {
		mapRenderer.dispose();
		map.dispose();

		for (Robot robot : robots) {
			robot.dispose();
		}
	}
	public void moveRobotKey(Robot robot) {
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			robot.setRelativePosition(0, 1);
			robot.setDirection(RobotDirection.NORTH);
			System.out.println("Moving to the UP");
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			robot.setRelativePosition(1, 0);
			robot.setDirection(RobotDirection.EAST);
			System.out.println("Moving to the RIGHT");
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			robot.setRelativePosition(-1, 0);
			robot.setDirection(RobotDirection.WEST);
			System.out.println("Moving to the LEFT");
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			robot.setRelativePosition(0, -1);
			robot.setDirection(RobotDirection.SOUTH);
			System.out.println("Moving to the LEFT");
		}
	}
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
	}

	@Override
	public void moveRobots() {
		// Lambda comparator to sort the robots based on priority
		PriorityQueue<Robot> robotMoveQueue = new PriorityQueue<>((r1, r2) -> {
			return Integer.compare(r1.getMove().getPriority(), r2.getMove().getPriority());
		});

		for (Robot r : robots) {
			robotMoveQueue.add(r);
		}

		// If there are no robots, return before NullPtrException
		if (robotMoveQueue.size() == 0)
			return;

		moveRobot(robotMoveQueue.poll());
	}

	public Batch getMapRendererBatch() {
		return mapRenderer.getBatch();
	}
}
