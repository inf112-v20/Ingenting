package inf112.skeleton.app.board;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import inf112.skeleton.app.object.Object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of <code>IBoard</code>.
 *
 * @author Jakob S
 * @see inf112.skeleton.app.board.IBoard
 */
public class Board implements IBoard {
	private TiledMap map;
	private Map<BoardLayerType, TiledMapTileLayer> layers;
	private OrthogonalTiledMapRenderer mapRenderer;

	/**
	 * Player layer.
	 *
	 * The player layer should not be a <code>TiledMapTileLayer</code> due to the playable elements needing
	 * 	a different datastructure to the base tiles (things that can move).
	 *
	 * 	This layer includes flags and respawn points.
	 */
	private ArrayList<Object> playerElements;

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
		layers.put(BoardLayerType.FLOOR,		(TiledMapTileLayer) map.getLayers().get("floor"));
		layers.put(BoardLayerType.INTERACTABLE,	(TiledMapTileLayer) map.getLayers().get("interactable"));

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
	public Object getElement(Vector2 pos) {
		return this.getElement((int) pos.x, (int) pos.y);
	}

	@Override
	public Object getElement(int x, int y) {	// TODO: Get a better solution than this
		for (Object o : playerElements) {
			if (o.getX() == x && o.getY() == y)
				return o;
		}

		return null;
	}

	@Override
	public boolean moveElement(Object elem, MoveType direction) {	// TODO: Setup logic for moving elements
		if (playerElements.contains(elem)) {
			return false;
		}

		return false;
	}

	@Override
	public boolean setElement(Object elem) {
		for (Object o : playerElements) {
			if (o.getX() == elem.getX() && o.getY() == elem.getY())
				return false;
		}

		playerElements.add(elem);

		return true;
	}

	@Override
	public boolean setElement(Object elem, Vector2 pos) {
		elem.setX((int) pos.x);
		elem.setY((int) pos.y);

		return setElement(elem);
	}

	@Override
	public boolean setElement(Object elem, int x, int y) {
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
