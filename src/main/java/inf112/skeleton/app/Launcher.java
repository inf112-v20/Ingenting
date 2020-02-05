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

public class Launcher extends ApplicationAdapter {
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    private TiledMap map;
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer objectLayer;

    private SpriteBatch batch;

    private ArrayList<TiledMapTileLayer.Cell> floorCells;
    private ArrayList<TiledMapTileLayer.Cell> interactableCells;


    @Override
    public void create() {
        //LOAD TILE MAP
        map = new TmxMapLoader().load("mainMap.tmx");

        //LAYERS
        boardLayer = (TiledMapTileLayer) map.getLayers().get("board");
        objectLayer = (TiledMapTileLayer) map.getLayers().get("interactables");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.zoom = 1f; // To be added when cards are added.
        camera.update();

        mapRenderer = new OrthogonalTiledMapRenderer(map, (float) 1/64);
        mapRenderer.setView(camera);


        //GET REFERENCE TO EVERY SINGLE CELL
        floorCells = new ArrayList<TiledMapTileLayer.Cell>();
        interactableCells = new ArrayList<TiledMapTileLayer.Cell>();
        for(int x = 0; x < boardLayer.getWidth(); x++){
            for(int y = 0; y < boardLayer.getHeight(); y++){
                TiledMapTileLayer.Cell floorCell = boardLayer.getCell(x, y);
                TiledMapTileLayer.Cell objectCell = objectLayer.getCell(x, y);
                floorCells.add(floorCell);
                interactableCells.add(objectCell);
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
