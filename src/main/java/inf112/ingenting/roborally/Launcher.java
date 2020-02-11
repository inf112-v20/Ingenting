package inf112.ingenting.roborally;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.BoardLayerType;
import inf112.ingenting.roborally.board.MoveType;
import inf112.ingenting.roborally.element.ElementType;
import inf112.ingenting.roborally.player.Robot;

import java.io.File;
import java.util.Iterator;

public class Launcher extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Board gameBoard;
    private Robot robot;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.zoom = 1f; // To be added when cards are added.
        camera.update();
        gameBoard = new Board("testMap.tmx", (float) 1 / 64, camera);

        TiledMapTileLayer.Cell cell =  gameBoard.getTile(0,0).get(1);
        robot = new Robot(0, 0, gameBoard, cell, BoardLayerType.INTERACTABLE);


    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        gameBoard.render();

        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            robot.move(MoveType.FORWARD);
            System.out.println("Should move.");
        }

    }

    @Override
    public void dispose() {
        gameBoard.dispose();
    }
}
