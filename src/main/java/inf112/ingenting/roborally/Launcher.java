package inf112.ingenting.roborally;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;

import java.io.File;
import java.util.Iterator;

public class Launcher extends ApplicationAdapter {
    private OrthographicCamera camera;
	private SpriteBatch batch;
    private Sprite sprite;
    private Texture player1;
    private Board gameBoard;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.zoom = 1f; // To be added when cards are added.
        camera.update();
        gameBoard = new Board("mainMap.tmx", (float) 1 / 64, camera);

        batch = new SpriteBatch();
        player1 = new Texture(Gdx.files.internal("player.png"));
        sprite = new Sprite(player1);


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

        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        gameBoard.dispose();
    }
}
