package inf112.ingenting.roborally.element;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.ingenting.roborally.board.BoardLayerType;

public interface IElement {
    void setXPosition(int x);

    int getXPosition();

    void setYPosition(int y);

    int getYPosition();

    BoardLayerType getLayer();

    TiledMapTileLayer.Cell getCell();
}
