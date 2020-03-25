package inf112.ingenting.roborally.gui;

import com.badlogic.gdx.Input;
import com.strongjoshua.console.Console;
import com.strongjoshua.console.GUIConsole;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.player.Player;


public class PlayerConsole {
	private Board board;
	private Console console;
	private MyCommandExecutor executor; // All methods what will be used in console window.

	/**
	 * Creates a console for the player so that the player can interact with the game.
	 * @param board that should be interacted.
	 * @param player that should interact with the game.
	 */
	public PlayerConsole(Board board, Player player) {
		this.board = board;
		console = new GUIConsole();
		executor = new MyCommandExecutor(board, player);

		console.setCommandExecutor(executor);
		console.setDisplayKeyID(Input.Keys.GRAVE);
		render();
	}

	/**
	 * Similar to first constructor, but does not create a GUI.
	 * Used for testing.
	 */
	public PlayerConsole(Board board, Player player, Boolean b){
		this.board = board;
		executor = new MyCommandExecutor(board, player);
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

	public void log(String s){
		console.log(s);
	}

	public MyCommandExecutor getExecutor() {
		return executor;
	}
}
