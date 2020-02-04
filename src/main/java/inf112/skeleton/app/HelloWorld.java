package inf112.skeleton.app;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class HelloWorld implements ApplicationListener {
    private TiledMap map;
    private TiledMapTileLayer boardLayer;
    OrthogonalTiledMapRenderer mapRenderer;
    OrthographicCamera camera;

    @Override
    public void create() {
        TmxMapLoader mapLoader = new TmxMapLoader();
        map = mapLoader.load("testMap.tmx");
        boardLayer = (TiledMapTileLayer) map.getLayers().get("testMap.tmx");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10, 10);
        camera.position.x = 5;
        camera.update();
        mapRenderer = new OrthogonalTiledMapRenderer(map, 300);
        mapRenderer.setView(camera);
    }
    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
    }
    @Override
    public void dispose() {
        mapRenderer.dispose();
        map.dispose();
    }
    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
}