package inf112.ingenting.roborally.player;

import com.badlogic.gdx.math.Vector2;
import com.strongjoshua.console.LogLevel;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.element.Flag;
import inf112.ingenting.roborally.gui.GameConsole;

public class Player {
	public static int DEFUALT_ROBOT_COUNT = 3;

	private int robotCount;
	private Robot[] robots;
	private Robot currentRobot;
	private Flag[] flags;
	private ProgrammingCard[] currentHand;


	// Noargs constructor for Kryo reg
	public Player() {}

	/**
	 * Creates a player with a skin that interacts with the board.
	 * @param amountOfRobots player should have
	 * @param startPos position of players robots.
	 * @param flags that player needs to reach to win.
	 * @param robotFile file of robot image.
	 */
	public Player(int amountOfRobots, Vector2 startPos, Flag[] flags, String robotFile){
		this.robotCount = amountOfRobots;
		this.robots = new Robot[amountOfRobots];
		this.flags = flags;

		// For now; currentHand is randomly assigned, when phases are implemented this will be changed.
		currentHand = new ProgrammingCard[5];
		for (int i = 0; i < 5; i++) {
			currentHand[i] = new ProgrammingCard();
		}

		for (int i = 0; i < amountOfRobots; i++) {
			robots[i] = new Robot(robotFile, startPos, flags);
		}
		currentRobot = robots[0];
	}

	/**
	 * Creates a player without a skin for testing purpose.
	 * @param amountOfRobots that player should have
	 * @param startPos position of all player robots.
	 */
	public Player(int amountOfRobots, Vector2 startPos){
		this.robotCount = amountOfRobots;
		this.robots = new Robot[amountOfRobots];

		for (int i = 0; i < amountOfRobots; i++) {
			robots[i] = new Robot(startPos);
		}
		currentRobot = robots[0];
	}

	// Used with networking shit
	String name;
	int id;

	public Player(String name, int id) {
		this.robotCount = DEFUALT_ROBOT_COUNT;
		this.robots = new Robot[1];

		this.name = name;
		this.id = id;

		// For now; currentHand is randomly assigned, when phases are implemented this will be changed.
		currentHand = new ProgrammingCard[5];
		for (int i = 0; i < 5; i++) {
			currentHand[i] = new ProgrammingCard();
		}
	}

	public void setRobot(Robot robot) {
		this.robots[0] = robot;
		this.currentRobot = robot;
	}

	public Robot getCurrentRobot(){
		return currentRobot;
	}

	public Robot[] getRobots(){
		return robots;
	}

	public int getRobotCount() {
		return robotCount;
	}

	public void showCards() {
		GameConsole.log("Cards:", LogLevel.SUCCESS);

		for (int i = 0; i < currentHand.length; i++) {
			GameConsole.log(
					"%d:   %s   %d",
					(i + 1),
					currentHand[i].getCardType().getName(),
					currentHand[i].getPriority()
			);
		}
	}
}
