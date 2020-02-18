package inf112.ingenting.roborally.board;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.element.Element;
import inf112.ingenting.roborally.player.Robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of <code>IBoard</code>.
 *
 * @author Jakob S
 * @see IBoard
 */
public class Board implements IBoard {
	private TiledMap map;
	private Map<BoardLayerType, TiledMapTileLayer> layers;
	private OrthogonalTiledMapRenderer mapRenderer;

	private final String LAYER_NAME_FLOOR			= "floor";
	private final String LAYER_NAME_INTERACTABLE	= "interactable";
	private final String LAYER_NAME_PLAYER 			= "player";

	/**
	 * Player layer.
	 *
	 * The player layer should not be a <code>TiledMapTileLayer</code> due to the playable elements needing
	 * 	a different datastructure to the base tiles (things that can move).
	 *
	 * 	This layer includes flags and respawn points.
	 */
	private ArrayList<Element> playerElements;

	/**
	 * Creates a board based on a Tiled (*.tmx) file.
	 *
	 * The constructor will attempt to use three layers, named:
	 * 	'floor',
	 * 	'interactable',
	 * 	'player'.
	 *
	 * The class will use tile type-names for gameplay-logic.
	 *
	 * @param filename	The name of the Tiled map to load
	 * @param unitScale	The per-tile pixel scaling to be used
	 *
	 * @throws IncorrectMapFormatException	If the Tiled map does not have the correct layer & tileset format.
	 */
	public Board(String filename, float unitScale, OrthographicCamera camera) throws IncorrectMapFormatException
	{
		map = new TmxMapLoader().load(filename);

		layers = new HashMap<>();
		layers.put(BoardLayerType.FLOOR,		(TiledMapTileLayer) map.getLayers().get(LAYER_NAME_FLOOR));
		layers.put(BoardLayerType.INTERACTABLE,	(TiledMapTileLayer) map.getLayers().get(LAYER_NAME_INTERACTABLE));
		layers.put(BoardLayerType.PLAYER,		(TiledMapTileLayer) map.getLayers().get(LAYER_NAME_PLAYER));
		//TODO: Add wall layer and player start.

		TiledMapTileLayer players = (TiledMapTileLayer) map.getLayers().get("players");
		if (players != null) {
			for (MapObject object : players.getObjects()) {
				// TODO: Get player elements
			}
		}

		/*	TODO: Redo tileset & map so that layer names & tile types are correctly formatted.
		for (TiledMapTileLayer layer : layers.values()) {
			if (layer == null) {
				throw new IncorrectMapFormatException();
			}
		}*/

		mapRenderer = new OrthogonalTiledMapRenderer(map, unitScale);
		mapRenderer.setView(camera);
	}

	@Override
	public void render() {
		mapRenderer.render();
	}

	@Override
	public void render(BoardLayerType layer) {
		mapRenderer.renderTileLayer(layers.get(layer));
	}

	@Override
	public Array<TiledMapTileLayer.Cell> getTile(Vector2 pos) {
		return this.getTile((int) pos.x, (int) pos.y);
	}

	@Override
	public Array<TiledMapTileLayer.Cell> getTile(int x, int y) {
		Array<TiledMapTileLayer.Cell> tile = new Array<>();

		tile.add(
			layers.get(BoardLayerType.FLOOR).getCell(x, y),
			layers.get(BoardLayerType.INTERACTABLE).getCell(x, y)
		);

		return tile;
	}

	@Override
	public Element getElement(Vector2 pos) {
		return this.getElement((int) pos.x, (int) pos.y);
	}

	@Override
	public Element getElement(int x, int y) {	// TODO: Get a better solution than this
		for (Element o : playerElements) {
			if (o.getX() == x && o.getY() == y)
				return o;
		}

		return null;
	}

	@Override
	public boolean moveRobot(Robot robot, MoveType move) {	// TODO: Setup logic for moving elements
		TiledMapTileLayer.Cell player_tile =  robot.getCell();
		TiledMapTileLayer.Cell empty_tile = new TiledMapTileLayer.Cell();
		TiledMapTileLayer playerLayer = layers.get(robot.getLayer());


		switch (move){
			case FORWARD:
				layers.get(robot.getLayer()).setCell(robot.getX(),robot.getY(), empty_tile);
				switch (robot.getDirection()){
					case NORTH:
						playerLayer.setCell(robot.getX(), robot.getY() + 1, player_tile);
						robot.setY(robot.getY() + 1);
						return true;
					case EAST:
						playerLayer.setCell(robot.getX() + 1, robot.getY(), player_tile);
						robot.setX(robot.getX() + 1);
						return true;
					case WEST:
						playerLayer.setCell(robot.getX() - 1, robot.getY(), player_tile);
						robot.setX(robot.getX() - 1);
						return true;
					case SOUTH:
						playerLayer.setCell(robot.getX(), robot.getY() - 1, player_tile);
						robot.setY(robot.getY() - 1);
						return true;
				}
		}
		return false;
	}

	@Override
	public boolean setElement(Element elem) {
		for (Element o : playerElements) {
			if (o.getX() == elem.getX() && o.getY() == elem.getY())
				return false;
		}

		playerElements.add(elem);
		return true;
	}

	@Override
	public boolean setElement(Element elem, Vector2 pos) {
		elem.setX((int) pos.x);
		elem.setY((int) pos.y);

		return setElement(elem);
	}

	@Override
	public boolean setElement(Element elem, int x, int y) {
		elem.setX(x);
		elem.setY(y);

		return setElement(elem);
	}

	@Override
	public void dispose() {
		mapRenderer.dispose();
		map.dispose();
	}
}
