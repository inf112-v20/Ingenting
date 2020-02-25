package inf112.ingenting.roborally.board;

import inf112.ingenting.roborally.player.Robot;

public interface IBoard {
	/**
	 * Renders the board.
	 */
	void render();

	/**
	 * Disposes of LibGDX objects.
	 */
	void dispose();

	/**
	 * Adds a robot to the board.
	 *
	 * @param robot	The robot to add
	 * @return		<code>true</code> if robot could be added
	 * 				<code>false</code> if there is already another robot in the
	 * 				new robot's board position
	 */
	boolean addRobot(Robot robot);

	/**
	 * Sets a robot in the given index / id.
	 *
	 * @param index	The index to add the robot to
	 * @param robot	The robot to add
	 * @return		<code>true</code> if robot could be added
	 * 				<code>false</code> if there is already another robot in the
	 * 				new robot's board position
	 */
	boolean setRobot(int index, Robot robot);

	/**
	 * Removes the robot in the given index.
	 *
	 * @param index The index of the robot to remove
	 */
	void removeRobot(int index);

	/**
	 * Moves all robots using internal Programming Cards.
	 */
	void moveRobots();
}
