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
    private TiledMapTileLayer blueLayer;
    private TiledMapTileLayer yellowLayer;
    private TiledMapTileLayer flagLayer;
    private TiledMapTileLayer repairLayer;
    private TiledMapTileLayer wallLayer;
    private TiledMapTileLayer holeLayer;
    private TiledMapTileLayer playerStartLayer;

    OrthogonalTiledMapRenderer mapRenderer;
    OrthographicCamera camera;

    private final String inputMap = "mainMap.tmx";
    private final String auxMap = "testMap.tmx";

    @Override
    public void create() {
        TmxMapLoader mapLoader = new TmxMapLoader();

        //Test map
        map = mapLoader.load(auxMap);

        //Main map
        //map = mapLoader.load(inputMap);

        boardLayer = (TiledMapTileLayer) map.getLayers().get("board");
        blueLayer = (TiledMapTileLayer) map.getLayers().get("blue");
        yellowLayer = (TiledMapTileLayer) map.getLayers().get("yellow");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("flag");
        repairLayer = (TiledMapTileLayer) map.getLayers().get("repair");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("wall");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("hole");
        playerStartLayer = (TiledMapTileLayer) map.getLayers().get("player_start");
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10, 10);
        camera.position.x = 5;
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