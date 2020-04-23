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

	private PlayerConsole gameConsole;
	private Player[] players;
	private Player currentPlayer;
	private Boolean gameWon = false;


	public Game(int amountOfPlayers, OrthographicCamera camera){
		players = new Player[amountOfPlayers];
		board = new Board("testMap.tmx", (float) 1 / 64, camera);
		gameConsole = PlayerConsole.getInstance();

		createPlayers(amountOfPlayers);
		currentPlayer = players[0];
	}

	public Game(int amountOfPlayers){
		players = new Player[amountOfPlayers];
		board = new Board();

		createPlayersNoSkin(amountOfPlayers);
	}

	public void render(){
		board.render();

		// Show Cards is temporarily kept here until phases are properly implemented
		currentPlayer.showCards();

		gameConsole.render();
		board.moveRobotKey(currentPlayer.getCurrentRobot());
		if(winCondition() && !gameWon){
			gameConsole.log("Game over!");
			gameWon = true;
		}
	}

	public void dispose(){
		board.dispose();
	}

	public void refresh(){
		gameConsole.render();
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
			players[i] = new Player(1, position, Board.getFlags(), path);
			board.addRobot(players[i].getCurrentRobot());
		}
	}

	public void createPlayersNoSkin(int amountOfPlayers){
		for (int i = 0; i < amountOfPlayers; i++) {
			Vector2 position = new Vector2(i+2, 0);
			players[i] = new Player(1, position);
			board.addRobot(players[i].getCurrentRobot());
		}
	}

	public Player[] getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

	public Boolean winCondition(){
		for (Player p: getPlayers()) {
			if (p.getCurrentRobot().getFlagsVisited() >= Board.getFlags().length){
				return true;
			}
		}
		return false;
	}
}
