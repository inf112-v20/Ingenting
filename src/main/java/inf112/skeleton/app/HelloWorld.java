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
    private TiledMapTileLayer wallLayer;
    private TiledMapTileLayer interactLayer;
    private TiledMapTileLayer playerStart;

    OrthogonalTiledMapRenderer mapRenderer;
    OrthographicCamera camera;

    private final String inputMap = "mainMap.tmx";
    private final String auxMap = "testMap.tmx";

    @Override
    public void create() {
        TmxMapLoader mapLoader = new TmxMapLoader();

        //Test map
        //map = mapLoader.load(auxMap);

        //Main map
        map = mapLoader.load(inputMap);

        boardLayer = (TiledMapTileLayer) map.getLayers().get("board");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("wall");
        interactLayer = (TiledMapTileLayer) map.getLayers().get("interactables");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("player_start");
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.update();

        mapRenderer = new OrthogonalTiledMapRenderer(map, (float) 1/64);
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
        camera.position.set((width / 2), (height / 2), 0);
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}