package inf112.ingenting.roborally.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.element.Flag;
import inf112.ingenting.roborally.player.Robot;
import inf112.ingenting.roborally.player.RobotDirection;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Board implements IBoard {
	public static final int LAYER_FLOOR = 0, LAYER_WALL = 1, LAYER_PLAYER_START = 2, LAYER_INTERACTABLE = 3;
	public static final int FLAG_1 = 55, FLAG_2 = 63, FLAG_3 = 71, FLAG_4 = 79;

	private TiledMap map;
	private TiledMapTileLayer[] layers;
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer mapRenderer;
	private Flag[] flags;

	private Array<Robot> robots;

	public Board(String fileName, float unitScale, OrthographicCamera camera) {
		map = new TmxMapLoader().load(fileName);
		layers = new TiledMapTileLayer[] {
				(TiledMapTileLayer) map.getLayers().get("floor"),
				(TiledMapTileLayer) map.getLayers().get("wall"),
				(TiledMapTileLayer) map.getLayers().get("player_start"),
				(TiledMapTileLayer) map.getLayers().get("interactable")
		};

		this.camera = camera;
		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);

		this.robots = new Array<>();
		this.flags = getFlags();

	}

	public Board(String fileName, float unitScale, OrthographicCamera camera, Array<Robot> robots) {
		map = new TmxMapLoader().load(fileName);

		layers = new TiledMapTileLayer[] {
				(TiledMapTileLayer) map.getLayers().get("floor"),
				(TiledMapTileLayer) map.getLayers().get("wall"),
				(TiledMapTileLayer) map.getLayers().get("player_start"),
				(TiledMapTileLayer) map.getLayers().get("interactable")
		};

		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);
		mapRenderer.setView(camera);

		this.robots = robots;
	}

	public Board() {
		this.robots = new Array<>();
	}

	public TiledMapTileLayer getLayer(int layerNum) {
		return layers[layerNum];
	}
	
	public Flag[] getFlags(){
		flags = new Flag[4];
		for (int y = 0; y < 12; y++) {
			for (int x = 0; x < 12 ; x++) {
				int tileId = getTileIdFromLayer(x, y, LAYER_INTERACTABLE);
				switch (tileId){
					case FLAG_1:
						flags[0] = new Flag(x, y, 1);
					case FLAG_2:
						flags[1] = new Flag(x, y, 2);
					case FLAG_3:
						flags[2] = new Flag(x, y, 3);
					case FLAG_4:
						flags[3] = new Flag(x, y, 4);
					default:
						continue;
				}
			}
		}
		return flags;
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
		if (layer < 0 || layer > 3)
			return false;

		layers[layer].setCell(x, y, tile);

		return true;
	}


	public boolean setTileCell(int x, int y, ArrayList<TiledMapTileLayer.Cell> tile) {

		for (int i = 0; i < layers.length; i++) {
			layers[i].setCell(x, y, tile.get(i));
		};

		return true;
	}

	public int getTileIdFromLayer(int x, int y, int layerID){
		if (layers[layerID].getCell(x,y) == null) {
			return 0;
		}
		return layers[layerID].getCell(x,y).getTile().getId();
	}

	public ArrayList<TiledMapTileLayer.Cell> getTileCells(int x, int y) {
		ArrayList<TiledMapTileLayer.Cell> cells = new ArrayList<TiledMapTileLayer.Cell>();
		for (int i = 0; i < layers.length; i++) {
			cells.add(layers[i].getCell(x, y));
		};
		return cells;
	}

	public void dispose() {
		mapRenderer.dispose();
		map.dispose();

		for (Robot robot : robots) {
			robot.dispose();
		}
	}
	public void moveRobotKey(Robot robot) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			robot.setRelativePosition(0, 1);
			robot.setDirection(RobotDirection.NORTH);
			checkFlag(robot);
			checkTile(robot);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
			robot.setRelativePosition(1, 0);
			robot.setDirection(RobotDirection.EAST);
			checkFlag(robot);
			checkTile(robot);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			robot.setRelativePosition(-1, 0);
			robot.setDirection(RobotDirection.WEST);
			checkFlag(robot);
			checkTile(robot);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			robot.setRelativePosition(0, -1);
			robot.setDirection(RobotDirection.SOUTH);
			checkFlag(robot);
			checkTile(robot);
		}
	}
	
	private void checkFlag(Robot robot){
		for (Flag f: getFlags()) {
			if(f.getXPosition() == robot.getPosition().x && f.getYPosition() == robot.getPosition().y){
				if(f.getLevel() == robot.getCurrentGoal().getLevel()){
					int newGoal = (robot.getCurrentGoal().getLevel() + 1) - 1;
					int idx = newGoal >= flags.length ? flags.length - 1 : newGoal;
					robot.setCurrentGoal(flags[idx]);
					robot.setFlagsVisited(robot.getFlagsVisited() + 1);
				}
			}
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
		if (flags != null){
			checkFlag(robot);
		}
		checkTile(robot);
	}

	public void checkTile(Robot robot) {
		//TODO Add collision checker
		int tileId = getTileIdFromLayer((int) robot.getPosition().x,(int) robot.getPosition().y, LAYER_INTERACTABLE);
		System.out.println(tileId);
		if (tileId == 6) {
			// Hole
			robot.setAlive(false);
		} else if (tileId == 15) {
			// Repair
			robot.setRelativeHP(1);
		} else if (tileId == 7) {
			// Double Repair
			robot.setRelativeHP(2);
		} else if (tileId == 39 || tileId == 47){
			// Single Laser
			robot.setRelativeHP(-1);
		} else if (tileId == 40 || tileId == 103 || tileId == 102){
			// Double Laser
			robot.setRelativeHP(-2);
		} else if (tileId == 101) {
			// Quadrouple Laser
			robot.setRelativeHP(-4);
		} else if (tileId == 21 || tileId == 20 || tileId == 17 || tileId == 75 || tileId == 86 || tileId == 82) {
			// Blue conveyor DOWN
			robot.setRelativePosition(0,-2);
		} else if (tileId == 22 || tileId == 28 || tileId == 18 || tileId == 76 || tileId == 85 || tileId == 83) {
			// Blue conveyor LEFT
			robot.setRelativePosition(-2,0);
		} else if (tileId == 19 || tileId == 14 || tileId == 25 || tileId == 74 || tileId == 78 || tileId == 81) {
			// Blue conveyor RIGHT
			robot.setRelativePosition(2,0);
		} else if (tileId == 13 || tileId == 27 || tileId == 26 || tileId == 73 || tileId == 77 || tileId == 84) {
			// Blue conveyor UP
			robot.setRelativePosition(0,2);
		} else if (tileId == 33 || tileId == 36 || tileId == 50 || tileId == 59 || tileId == 62 || tileId == 67) {
			// Yellow conveyor DOWN
			robot.setRelativePosition(0,-1);
		} else if (tileId == 34 || tileId == 44 || tileId == 51 || tileId == 60 || tileId == 68 || tileId == 70) {
			// Yellow conveyor LEFT
			robot.setRelativePosition(-1,0);
		} else if (tileId == 35 || tileId == 41 || tileId == 52 || tileId == 58 || tileId == 61 || tileId == 66) {
			// Yellow conveyor RIGHT
			robot.setRelativePosition(1,0);
		} else if (tileId == 42 || tileId == 43 || tileId == 49 || tileId == 57 || tileId == 65 || tileId == 69) {
			// Yellow conveyor UP
			robot.setRelativePosition(0,1);
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

}
