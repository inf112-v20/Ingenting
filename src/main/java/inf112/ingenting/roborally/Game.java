package inf112.ingenting.roborally;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.gui.PlayerConsole;
import inf112.ingenting.roborally.player.Player;

/**
 * Handles round logic and controls the game.
 */
public class Game {

	private Board board;
	private PlayerConsole currentConsole;
	private Player[] players;
	private PlayerConsole[] playerConsoles;


	public Game(int amountOfPlayers, OrthographicCamera camera){
		players = new Player[amountOfPlayers];
		playerConsoles = new PlayerConsole[amountOfPlayers];
		board = new Board("testMap.tmx", (float) 1 / 64, camera);

		createPlayers(amountOfPlayers);
		currentConsole = playerConsoles[0];
	}

	public Game(int amountOfPlayers){
		players = new Player[amountOfPlayers];
		playerConsoles = new PlayerConsole[amountOfPlayers];
		board = new Board();

		createPlayersNoSkin(amountOfPlayers);
		currentConsole = playerConsoles[0];
	}

	public void render(){
		board.render();
		currentConsole.render();
	}

	public void dispose(){
		board.dispose();
		for (PlayerConsole c: playerConsoles) {
			c.refresh();
		}
	}

	public void refresh(){
		currentConsole.render();
	}

	/**
	 * Creates a board with given amount of players.
	 * Creates given amount of players and initiates a robot on the board
	 * for each player and adds current robot to map.
	 * @param amountOfPlayers that should be in the game.
	 */
	public void createPlayers(int amountOfPlayers){
		for (int i = 0; i < amountOfPlayers; i++) {
			Vector2 position = new Vector2(i+2, 0);
			String path = String.format("player_%x.png", i+1);
			players[i] = new Player(1, position, path);
			playerConsoles[i] = new PlayerConsole(board, players[i]);
			board.addRobot(players[i].getCurrentRobot());
		}
	}

	public void createPlayersNoSkin(int amountOfPlayers){
		for (int i = 0; i < amountOfPlayers; i++) {
			Vector2 position = new Vector2(i+2, 0);
			players[i] = new Player(1, position);
			playerConsoles[i] = new PlayerConsole(board, players[i], false);
			board.addRobot(players[i].getCurrentRobot());
		}
	}

	public Player[] getPlayers() {
		return players;
	}

	public PlayerConsole getConsole() {
		return currentConsole;
	}

	public Board getBoard() {
		return board;
	}
}
