package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Launcher extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Board board;
    private SpriteBatch batch;


    /**
     * Textures to be added.
     */
    private Texture tileTexture;
    private Texture flagTexture;
    private Texture robotTexture;

    @Override
    public void create() {
        //LOAD TEXTURES
        tileTexture = new Texture(Gdx.files.internal("tile.png"));
        flagTexture = new Texture(Gdx.files.internal("flag.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, board.getWidth(), board.getHeight());
        board = new Board();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        for (IObject drawable: board.gameObjects()){
            Texture texture = objectFactory(drawable.getTexture());
            batch.draw(texture, drawable.getX(), drawable.getY());
        }
        batch.end();
    }

    @Override
    public void dispose() {
        tileTexture.dispose();
        batch.dispose();
    }

    private Texture objectFactory(ObjectType type) {
        switch(type){
            case ROBOT:
                return robotTexture;
            case TILE:
                return tileTexture;
            case FLAG:
                return flagTexture;
        }
        return null;
    }
}

