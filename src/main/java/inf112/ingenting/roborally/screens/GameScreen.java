package inf112.ingenting.roborally.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.kryonet.Connection;
import com.strongjoshua.console.LogLevel;
import inf112.ingenting.roborally.RoboRally;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.gui.GameConsole;
import inf112.ingenting.roborally.networking.Network;
import inf112.ingenting.roborally.player.Player;
import inf112.ingenting.roborally.player.Robot;

/**
 * The main screen for the game. Handles all game logic & rendering.
 */
public class GameScreen extends ScreenAdapter {
	private RoboRally game;
	private Board board;
	private GameConsole console;

	// Array of all players
	private Array<Player> players;

	// Turn stuff
	private int turnCounter = 0;
	private char phaseCounter = 0;
	private boolean nextTurn = false;

	// Networking stuff
	Network network;
	boolean isNetworkHost = true;
	boolean gameStarted = false;

	/**
	 * Creates the screen & a game board.
	 *
	 * @param game The RoboRally main class
	 */
	public GameScreen(RoboRally game) {
		this.game = game;
		this.board = this.game.createBoard("testMap.tmx");
		this.console = GameConsole.getInstance();
		// Listener for certain console commands
		this.console.setGameScreenListener(this);

		this.network = Network.getInstance();

		this.players = new Array<>();
	}

	@Override
	public void show() {
		for (int i = 0; i < 5; i++) {
			game.getAssetManager().load("player_" + i + ".png", Texture.class);
		}
	}

	@Override
	public void render(float delta) {
		switch (network.getNetworkType()) {
			case HOST:
				break;
			case CLIENT:
				if (network.client.arePlayersUpdated()) {
					players = network.client.getPlayers();
					board.clearRobots();
					for (Player p : players)
						board.addRobot(p.getCurrentRobot());
				}
				break;
			case NONE:
			default:
				break;
		}

		board.render();
		console.render();
	}

	@Override
	public void dispose() {
		board.dispose();
	}

	// Strange temporary listener for showCards console command
	public void showCards() {
		// Temporarily pretending that local player is always index 0
		if (players.get(0) != null)
			players.get(0).showCards();
		else
			GameConsole.log("Could not get cards", LogLevel.ERROR);
	}

	public void startGame() {
		if (network.getNetworkType() != Network.NetworkType.HOST) {
			GameConsole.log("You must be host to start a game.");
			return;
		}

		GameConsole.log("Starting game.");

		// Host is not part of network connections and needs it's own player
		Player host = new Player("Host", -1);
		host.setRobot(new Robot("player_4.png", new Vector2(0, 0)));
		board.addRobot(host.getCurrentRobot());
		players.add(host);

		Connection[] connections = network.host.getConnections();

		int textureNum = 0;
		for (Connection c : connections) {
			Player p = new Player(c.toString(), c.getID());
			p.setRobot(new Robot("player_" + textureNum++ + ".png", new Vector2(textureNum, 0)));
			board.addRobot(p.getCurrentRobot());
			players.add(p);

			if (textureNum > 4)
				textureNum = 0;
		}

		network.host.sendPlayers(players);



		gameStarted = true;
	}
}
