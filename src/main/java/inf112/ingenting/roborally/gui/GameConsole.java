package inf112.ingenting.roborally.gui;

import com.badlogic.gdx.Input;
import com.strongjoshua.console.Console;
import com.strongjoshua.console.GUIConsole;
import com.strongjoshua.console.LogLevel;

public class GameConsole {
	private Console console;
	private MyCommandExecutor executor; // All methods what will be used in console window.

	private static GameConsole instance;

	private GameConsole() {
		console = new GUIConsole();
		executor = new MyCommandExecutor();

		console.setCommandExecutor(executor);
		console.setDisplayKeyID(Input.Keys.GRAVE);
		render();
	}

	public static GameConsole getInstance() {
		if (instance == null)
			instance = new GameConsole();

		return instance;
	}

	public void dispose(){
		console.dispose();
	}

	public void render(){
		if(!console.isVisible()){
			console.setVisible(true);
		}
		console.setSizePercent(100, 30);
		console.setPosition(0, 800);
		console.draw();

	}
	public void refresh(){
		console.refresh();
	}

	public void log(String message) {
		console.log(message);
	}

	public void log(String message, LogLevel level) {
		console.log(message, level);
	}
}
