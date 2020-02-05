package inf112.skeleton.app.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import inf112.skeleton.app.object.Object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board implements IBoard {
	private TiledMap map;
	private Map<BoardLayerType, TiledMapTileLayer> layers;

	/**
	 * Player layer.
	 *
	 * The player layer should not be a <code>TiledMapTileLayer</code> due to the playable elements needing
	 * 	a different datastructure to the base tiles.
	 *
	 * 	This layer includes flags and respawn points.
	 */
	private ArrayList<Object> players;

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
	 * @throws IncorrectMapFormatException	If the Tiled map does not use the correct format.
	 */
	public Board(String filename, float unitScale) throws IncorrectMapFormatException
	{
		map = new TmxMapLoader().load(filename);

		layers = new HashMap<>();
		layers.put(BoardLayerType.FLOOR,		(TiledMapTileLayer) map.getLayers().get("floor"));
		layers.put(BoardLayerType.INTERACTABLE,	(TiledMapTileLayer) map.getLayers().get("interactable"));
	}

	@Override
	public void Render(SpriteBatch batch) {

	}

	@Override
	public void Render(SpriteBatch batch, BoardLayerType layer) {

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
	public Object getElement(int x, int y) {
		for (Object o : players) {	// TODO: get a better solution than this
			if (o.getX() == x && o.getY() == y)
				return o;
		}

		return null;
	}

	@Override
	public boolean moveElement(Object elem, MoveType direction) {
		if (players.contains(elem)) {
			return false;	// TODO: finish
		}

		return false;
	}

	@Override
	public boolean setElement(Object elem, Vector2 pos) {
		return false;	// TODO: Currently no way to set entity position
	}

	@Override
	public boolean setElement(Object elem, int x, int y) {
		return false;
	}
}
