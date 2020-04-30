package inf112.ingenting.roborally;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.gui.GameConsole;
import inf112.ingenting.roborally.screens.GameScreen;
import inf112.ingenting.roborally.screens.ScreenType;

import java.util.HashMap;
import java.util.Map;

public class RoboRally extends Game {
	private AssetManager assetManager;
	private OrthographicCamera camera;

	private Map<ScreenType, ScreenAdapter> screens;

	@Override
	public void create() {
		this.assetManager = new AssetManager();
		// Setting the loader for TiledMaps
		this.assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));

		this.camera = new OrthographicCamera();

		this.screens = new HashMap<>();
		this.screens.put(ScreenType.GAME, new GameScreen(this));

		this.setScreen(screens.get(ScreenType.GAME));
	}

	public Board createBoard(String filename) {
		return new Board(this.assetManager, filename, this.camera);
	}

	@Override
	public void dispose() {
		assetManager.dispose();
		for (ScreenAdapter screen : screens.values())
			screen.dispose();

		if (GameConsole.isInstantiated())
			GameConsole.getInstance().dispose();
	}

	public AssetManager getAssetManager() {
		return this.assetManager;
	}
}
