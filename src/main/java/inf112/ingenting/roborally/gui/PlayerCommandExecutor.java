package inf112.ingenting.roborally.gui;

import com.strongjoshua.console.CommandExecutor;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.MoveType;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import inf112.ingenting.roborally.player.Player;

/**
 * PlayerCommandExecutor is a class that represents the methods that the player can execute by using
 * the in-game console.
 */
public class PlayerCommandExecutor extends CommandExecutor {

	Board board;
	Player player;

	/**
	 * Creates a console which player can perform commands on.
	 * @param board that commands should interact with.
	 * @param player that interacts with the board.
	 */
	public PlayerCommandExecutor(Board board, Player player){
		this.board = board;
		this.player = player;
	}

	public void move1(){
		player.getCurrentRobot().registerMove(new ProgrammingCard(ProgrammingCardType.MOVE_1));
		board.moveRobots();
	}
}
