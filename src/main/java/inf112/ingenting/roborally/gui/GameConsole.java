package inf112.ingenting.roborally.gui;

import com.badlogic.gdx.Input;
import com.strongjoshua.console.Console;
import com.strongjoshua.console.GUIConsole;
import inf112.ingenting.roborally.board.Board;


public class GameConsole {
	private Board board;
	private Console console;
	private MyCommandExecutor executor; // All methods what will be used in console window.

	public GameConsole(Board board) {
		this.board = board;
		console = new GUIConsole();
		executor = new MyCommandExecutor();

		console.setCommandExecutor(executor);
		console.setDisplayKeyID(Input.Keys.GRAVE);
		render();
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

}
