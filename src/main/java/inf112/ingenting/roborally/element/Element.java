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
    private int width = 64;
    private int height = 64;
    private int rotation = 0;

    private BoardLayerType layer;
    private ElementType type;
    private TiledMapTileLayer.Cell cell;

    private int x;
    private int y;

    /**
     * Create a drawable element with a default width and height of 64.
     * @param x position
     * @param y positon
     * @param type of the object for example ROBOT.
     */
    public Element(int x, int y, ElementType type, TiledMapTileLayer.Cell cell, BoardLayerType layer) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.cell = cell;
        this.layer = layer;
    }

    public Element(int x, int y, ElementType type, BoardLayerType layer){
        this.x = x;
        this.y = y;
        this.type = type;
        this.layer = layer;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return  x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setRotation(int rot) {
        this.rotation = rot;
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    @Override
    public void setType(ElementType type) {
        this.type = type;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public BoardLayerType getLayer() {
        return layer;
    }

    @Override
    public TiledMapTileLayer.Cell getCell() {
        return cell;
    }

    public void setCell(TiledMapTileLayer.Cell cell) {
        this.cell = cell;
    }
}
