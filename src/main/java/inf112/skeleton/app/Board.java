package inf112.skeleton.app;

import inf112.skeleton.app.object.IObject;
import inf112.skeleton.app.object.Object;
import inf112.skeleton.app.object.ObjectType;

import java.util.ArrayList;

public class Board  {
    private final int TILE_SIZE = 64;
    private final int TILE_NUMBER = 12;
    private final int BOARD_WIDTH = TILE_NUMBER * TILE_SIZE;
    private final int BOARD_HEIGHT = TILE_NUMBER * TILE_SIZE;

    private ArrayList<IObject> objects;

    public Board(){
        objects = gameObjects();
    }

    public int getWidth() {
        return BOARD_WIDTH;
    }

    public int getHeight() {
        return BOARD_HEIGHT;
    }

    ArrayList<IObject> gameObjects() {
        objects = new ArrayList<IObject>();
        for(int y = 0; y < TILE_NUMBER; y++){
            for(int x = 0; x < TILE_NUMBER; x++){
                Object tile = new Object(x * TILE_SIZE, y * TILE_SIZE, ObjectType.TILE);
                objects.add(tile);
            }
        }
        int idx = convertTo2D(1, 0);
        objects.set(idx, new Object(1 * TILE_SIZE, 0 * TILE_SIZE, ObjectType.FLAG));
        return objects;
    }

    public int convertTo2D(int x, int y){
        int result = y * BOARD_WIDTH + x;
        return result;
    }
}
