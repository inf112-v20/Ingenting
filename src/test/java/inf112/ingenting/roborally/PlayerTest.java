package inf112.ingenting.roborally;

import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void startPosOfRobot(){
		Vector2 testPosition = new Vector2(5, 5);
		Player player = new Player(2, testPosition);
		Assert.assertEquals(testPosition, player.getCurrentRobot().getPosition());
	}

	@Test
	public void correctAmountOfRobots(){
		int testAmount = 4;
		Player player = new Player(testAmount, new Vector2(0, 0));
		Assert.assertEquals(testAmount, player.getAmountOfRobots());
	}

	@Test
	public void currentRobotEqualFirstRobot(){
		Player player = new Player(2, new Vector2(0, 0));
		Assert.assertEquals(player.getCurrentRobot(), player.getRobots()[0]);
	}


}
