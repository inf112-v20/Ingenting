package inf112.ingenting.roborally.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.strongjoshua.console.Console;
import com.strongjoshua.console.GUIConsole;
import com.strongjoshua.console.LogLevel;
import inf112.ingenting.roborally.screens.GameScreen;

public class GameConsole {
	private Console console;
	private GameCommandExecutor executor; // All methods what will be used in console window.

	private static GameConsole instance;

	private GameConsole() {
		console = new GUIConsole();
		executor = new GameCommandExecutor();
		console.setCommandExecutor(executor);
		console.setDisplayKeyID(Input.Keys.GRAVE);
		render();
	}

	public static GameConsole getInstance() {
		if (instance == null)
			instance = new GameConsole();

		return instance;
	}

	public static boolean isInstantiated() {
		return instance != null;
	}

	public void dispose(){
		console.dispose();
	}

	public void render(){
		if(!console.isVisible()){
			console.setVisible(true);
		}
		console.setSizePercent(50, 100);
		console.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
		console.draw();
	}

	public void refresh(){
		console.refresh();
	}

	static public void log(String message) {
		GameConsole.getInstance().console.log(message);
	}

	static public void log(String message, LogLevel level) {
		GameConsole.getInstance().console.log(message, level);
	}

	static public void log(String message, Object ... args) {
		GameConsole.getInstance().console.log(String.format(message, args));
	}

	public void setGameScreenListener(GameScreen listener) {
		executor.setGameScreenListener(listener);
	}
}
