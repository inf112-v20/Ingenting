package inf112.ingenting.roborally;

import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import inf112.ingenting.roborally.gui.MyCommandExecutor;
import inf112.ingenting.roborally.player.Player;
import inf112.ingenting.roborally.player.Robot;
import inf112.ingenting.roborally.player.RobotDirection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandExecutorTest {
	Game game;
	Player player;
	MyCommandExecutor executor;
	@Before
	public void setup() {
		game = new Game(1);
		player = game.getPlayers()[0];
		executor = game.getConsole().getExecutor();
	}

	@Test
	public void movePlayer1Robot1(){
		Vector2 currentPosition = new Vector2(player.getCurrentRobot().getPosition());
		executor.move1();
		Vector2 expectedPosition = new Vector2(currentPosition.x, currentPosition.y + 1);
		Assert.assertEquals(expectedPosition, player.getCurrentRobot().getPosition());
	}

}
