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
     * Create a drawable element with a default width and height of 64.
     * @param x position
     * @param y positon
     */
    public Element(int x, int y, TiledMapTileLayer.Cell cell, BoardLayerType layer) {
        this.xPosition = x;
        this.yPosition = y;
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
