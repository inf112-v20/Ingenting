package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;
import java.util.Map;

public class Launcher2 extends ApplicationAdapter {
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    private TiledMap map;
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer holeLayer;

    private SpriteBatch batch;

    private ArrayList<TiledMapTileLayer.Cell> cellsInScene;

    private Map<String, TiledMapTile> tiles;

    private TiledMapTileSet tiledMapTileSet;



    @Override
    public void create() {
        //LOAD TILE MAP
        map = new TmxMapLoader().load("testMap.tmx");

        //LAYERS
        boardLayer = (TiledMapTileLayer) map.getLayers().get("Board");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10, 10);
        camera.position.x = 5;
        camera.zoom = 1.5f;
        camera.update();

        mapRenderer = new OrthogonalTiledMapRenderer(map, (float) 1/64);
        mapRenderer.setView(camera);


        //GET REFERENCE TO EVERY SINGLE CELL
        cellsInScene = new ArrayList<TiledMapTileLayer.Cell>();
        for(int x = 0; x < boardLayer.getWidth(); x++){
            for(int y = 0; y < boardLayer.getHeight(); y++){
                TiledMapTileLayer.Cell cell = boardLayer.getCell(x, y);
                System.out.println(cell.getTile().getId());
                cellsInScene.add(cell);
            }
        }

    }

    @Override
    public void resize(int width, int height) {
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
}
