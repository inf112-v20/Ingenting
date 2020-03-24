package inf112.ingenting.roborally.gui;

import com.badlogic.gdx.Input;
import com.strongjoshua.console.Console;
import com.strongjoshua.console.GUIConsole;


public class GameConsole {
	private Console console;
	private MyCommandExecutor executor; // All methods what will be used in console window.

	public GameConsole() {
		console = new GUIConsole();
		executor = new MyCommandExecutor();

		console.setCommandExecutor(executor);
		console.setDisplayKeyID(Input.Keys.W);
		console.draw();
	}


	public void dispose(){
		console.dispose();
	}

	public void draw(){
		console.draw();
	}
}
