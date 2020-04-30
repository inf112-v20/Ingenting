package inf112.ingenting.roborally.player;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import inf112.ingenting.roborally.util.GdxTestRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Class for testing expected behavior of the robot.
 */
@RunWith(GdxTestRunner.class)
public class RobotTest {
	AssetManager assetManager;
	Board board;
	Robot robot;
	Vector2 startPosition;

	@Before
	public void setup() {
		assetManager = new AssetManager();
		assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));

		board = new Board(assetManager, "testMap.tmx");

		startPosition = new Vector2(0, 0);
		robot = new Robot(startPosition);

		board.addRobot(robot);
	}

	@Test
	public void addNewRobotToBoard() {
		Vector2 position = new Vector2(0, 1);

		Robot robot2 = new Robot(position);
		board.addRobot(robot2);

		Assert.assertEquals(2, board.getRobots().size);
	}

	@Test
	public void cannotAddNewRobotInSamePositionAsExistingRobot()
	{
		Robot robot2 = new Robot(startPosition);

		Assert.assertFalse(board.addRobot(robot2));
	}

	@Test
	public void RobotMovesForwardWhenFacingNorth() {
		robot.setDirection(RobotDirection.NORTH);
		robot.registerMove(new ProgrammingCard(ProgrammingCardType.MOVE_1));

		board.moveRobots();
		Assert.assertEquals(new Vector2(0, 1), robot.getPosition());
	}

	@Test
	public void RobotRotatesLeft() {
		robot.setDirection(RobotDirection.NORTH);
		robot.registerMove(new ProgrammingCard(ProgrammingCardType.ROTATE_LEFT));

		board.moveRobots();
		Assert.assertEquals(startPosition, robot.getPosition());
		Assert.assertEquals(RobotDirection.WEST, robot.getDirection());
	}

	@Test
	public void RobotRotatesRight() {
		robot.setDirection(RobotDirection.NORTH);
		robot.registerMove(new ProgrammingCard(ProgrammingCardType.ROTATE_RIGHT));

		board.moveRobots();
		Assert.assertEquals(startPosition, robot.getPosition());
		Assert.assertEquals(RobotDirection.EAST, robot.getDirection());
	}

	@Test
	public void RobotDeactivateOnMoveOutsideBoard(){
		robot.setDirection(RobotDirection.WEST);
		robot.registerMove(new ProgrammingCard(ProgrammingCardType.MOVE_1));

		Assert.assertEquals(robot.getActive(), true);
		board.moveRobots();
		Assert.assertEquals(robot.getActive(), false);
		Assert.assertEquals(robot.getPosition(), startPosition);
	}

}