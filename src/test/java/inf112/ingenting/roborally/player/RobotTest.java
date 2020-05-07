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

	@Test
	public void RobotDeactivatesOnHole() {
		Vector2 objectPosition = new Vector2(3 ,5);
		robot.setPosition(objectPosition);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "hole");
		Assert.assertEquals(false, robot.getActive());
	}

	@Test
	public void RobotRepairOnWrench() {
		Vector2 objectPosition = new Vector2(0, 0);
		int currentHealth = robot.getHp();
		robot.setPosition(objectPosition);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "repair");
		Assert.assertEquals(currentHealth + 1, robot.getHp());
	}

	@Test
	public void RobotMoveOnConveyorNorth() {
		Vector2 objectPosition = new Vector2(5, 8);
		robot.setPosition(objectPosition);
		Vector2 currentPosition = robot.getPosition();
		Vector2 expectedPos = new Vector2(robot.getPosition().x, robot.getPosition().y + 2);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "conveyor");
		Assert.assertEquals(board.getProperty(objectPosition, "direction"), "north");
		Assert.assertEquals(expectedPos, currentPosition);
	}

	@Test
	public void RobotMoveOnConveyorEast() {
		Vector2 objectPosition = new Vector2(6, 8);
		robot.setPosition(objectPosition);
		Vector2 currentPosition = robot.getPosition();
		Vector2 expectedPos = new Vector2(robot.getPosition().x + 2, robot.getPosition().y);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "conveyor");
		Assert.assertEquals(board.getProperty(objectPosition, "direction"), "east");
		Assert.assertEquals(expectedPos, currentPosition);
	}

	@Test
	public void RobotMoveOnConveyorSouth() {
		Vector2 objectPosition = new Vector2(7, 8);
		robot.setPosition(objectPosition);
		Vector2 currentPosition = robot.getPosition();
		Vector2 expectedPos = new Vector2(robot.getPosition().x, robot.getPosition().y - 2);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "conveyor");
		Assert.assertEquals(board.getProperty(objectPosition, "direction"), "south");
		Assert.assertEquals(expectedPos, currentPosition);
	}

	@Test
	public void RobotMoveOnConveyorWest() {
		Vector2 objectPosition = new Vector2(8, 8);
		robot.setPosition(objectPosition);
		Vector2 currentPosition = robot.getPosition();
		Vector2 expectedPos = new Vector2(robot.getPosition().x - 2, robot.getPosition().y);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "conveyor");
		Assert.assertEquals(board.getProperty(objectPosition, "direction"), "west");
		Assert.assertEquals(expectedPos, currentPosition);
	}

	@Test
	public void RobotOnLaser() {
		Vector2 objectPosition = new Vector2(3, 2);
		int currentHp = robot.getHp();
		int expectedHp = currentHp - 2;
		robot.setPosition(objectPosition);
		board.checkTile(robot);
		Assert.assertEquals(board.getProperty(objectPosition, "type"), "laser");
		Assert.assertEquals(expectedHp, robot.getHp());
	}





}
