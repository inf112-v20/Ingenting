package inf112.ingenting.roborally;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.BoardLayerType;
import inf112.ingenting.roborally.player.Robot;

public class Launcher extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Board board;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.zoom = 1f; // To be added when cards are added.
        camera.update();
        this.board = new Board("testMap.tmx", (float) 1 / 64, camera);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        board.render();
    }

    @Override
    public void dispose() {
        board.dispose();
    }
}
