package inf112.ingenting.roborally;

import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.gui.PlayerCommandExecutor;
import inf112.ingenting.roborally.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandExecutorTest {
	Game game;
	Player player;
	PlayerCommandExecutor executor;
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
