package inf112.ingenting.roborally;

import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.player.Robot;
import org.junit.Before;
import org.junit.Test;

/**
 * Class for testing expected behavior of the robot.
 */
public class RobotTest {
	private OrthographicCamera camera;
	private Board board;

	@Before
	public void setup(){
		camera = new OrthographicCamera();
		board = new Board("testMap.tmx", (float) 1/64, camera);

	}

	@Test
	public void canRobotMoveForwardWhenDirectionNorth(){

	}

}
