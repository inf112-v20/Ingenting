package inf112.ingenting.roborally;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.ingenting.roborally.board.*;
import org.junit.Test;

public class FlagTest {

    private static OrthographicCamera camera;

    @Test
    public static void checkObjectType(){
        Board board = new Board("FLAG_TEST_MAP.tmx", (float) 1 / 64, camera);
        TiledMapTileLayer interactLayer = board.getLayer(Board.LAYER_INTERACTABLE);
        // TODO
        // What does the cell return? Access property/type to find what we can access.
        System.out.println(interactLayer.getCell(0,0));
        System.out.println(interactLayer.getCell(0,1));
        System.out.println(interactLayer.getCell(0,2));
        System.out.println(interactLayer.getCell(0,3));
    }

}
