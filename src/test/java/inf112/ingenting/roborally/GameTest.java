package inf112.ingenting.roborally;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

	@Test
	public void checkCreationOfGameWith2Players(){
		Game game = new Game(2);
		Assert.assertEquals((game.getPlayers().length), 2);
	}

}
