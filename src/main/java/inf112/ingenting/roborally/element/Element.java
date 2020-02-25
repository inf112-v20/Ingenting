/**
 * Implementation of <code>IElement</code>.
 *
 * @author Ayoub Tammaoui
 * @see IElement
 */

package inf112.ingenting.roborally.element;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.ingenting.roborally.board.BoardLayerType;

public class Element implements IElement {
	private BoardLayerType layer;
	private TiledMapTileLayer.Cell cell;

	private int xPosition;
	private int yPosition;

	/**
	 * Create a element that exists on map.
	 * Every element as a position, cell and a layer.
	 * @param x position
	 * @param y position
	 * @param cell Represents a position on the map.
	 * @param layer Layer that element is in.
	 */
	public Element(int x, int y, TiledMapTileLayer.Cell cell, BoardLayerType layer) {
		this.yPosition = y;
		this.xPosition = x;
		this.cell = cell;
		this.layer = layer;
	}

	@Override
	public void setXPosition(int x) {
		this.xPosition = x;
	}

	@Override
	public int getXPosition() {
		return xPosition;
	}

	@Override
	public void setYPosition(int y) {
		this.yPosition = y;
	}

	@Override
	public int getYPosition() {
		return yPosition;
	}

	@Override
	public BoardLayerType getLayer() {
		return layer;
	}

	@Override
	public TiledMapTileLayer.Cell getCell() {
		return cell;
	}
}
