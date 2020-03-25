package inf112.ingenting.roborally.player;

import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.gui.PlayerConsole;

public class Player {

	private int amountOfRobots;
	private Robot[] robots;
	private Robot currentRobot;

	public Player(int amountOfRobots, Vector2 startPos, String robotFile){
		this.amountOfRobots = amountOfRobots;
		this.robots = new Robot[amountOfRobots];

		for (int i = 0; i < amountOfRobots; i++) {
			robots[i] = new Robot(robotFile, startPos);
		}
		currentRobot = robots[0];
	}

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
}
