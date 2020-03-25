package inf112.ingenting.roborally.gui;

import com.strongjoshua.console.CommandExecutor;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.MoveType;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import inf112.ingenting.roborally.player.Player;

public class MyCommandExecutor extends CommandExecutor {

	Board board;
	Player player;

	public MyCommandExecutor(Board board, Player player){
		this.board = board;
		this.player = player;
	}


	public void move1(){
		player.getCurrentRobot().registerMove(new ProgrammingCard(ProgrammingCardType.MOVE_1));
		board.moveRobots();
	}
}
