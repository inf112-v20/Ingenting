package inf112.ingenting.roborally.player;

import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.element.Flag;
import inf112.ingenting.roborally.gui.PlayerConsole;

public class Player {

	private int amountOfRobots;
	private Robot[] robots;
	private Robot currentRobot;
	private Flag[] flags;
	private ProgrammingCard[] currentHand;

	/**
	 * Creates a player with a skin that interacts with the board.
	 * @param amountOfRobots player should have
	 * @param startPos position of players robots.
	 * @param flags that player needs to reach to win.
	 * @param robotFile file of robot image.
	 */
	public Player(int amountOfRobots, Vector2 startPos, Flag[] flags, String robotFile){
		this.amountOfRobots = amountOfRobots;
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
		this.amountOfRobots = amountOfRobots;
		this.robots = new Robot[amountOfRobots];

		for (int i = 0; i < amountOfRobots; i++) {
			robots[i] = new Robot(startPos);
		}
		currentRobot = robots[0];
	}


	public Robot getCurrentRobot(){
		return currentRobot;
	}

	public Robot[] getRobots(){
		return robots;
	}

	public int getAmountOfRobots() {
		return amountOfRobots;
	}

	public void showCards() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < currentHand.length; i++) {
			out.append(i + 1).append(": ")
					.append(currentHand[i].getCardType().toString().toLowerCase()).append("   ")
					.append(currentHand[i].getPriority())
					.append("\n");
		}

		PlayerConsole.getInstance().log(out.toString());
	}
}
