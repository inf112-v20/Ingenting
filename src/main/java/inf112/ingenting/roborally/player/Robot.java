package inf112.ingenting.roborally.player;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import inf112.ingenting.roborally.element.Flag;

public class Robot {

	private Flag currentGoal;
	private Flag[] flags;
	private int flagsVisited = 0;

	private Vector2 position;
	private RobotDirection direction;
	private ProgrammingCard lastCard;

	private String texturePath;
	private Boolean active = true;

	private Boolean isAlive = true;
	private int hp = 10;

	// No-args constructor for Kryo serialization
	public Robot() {}

	/**
	 * Creates a robot that can move and capture flags in the game.
	 * @param texturePath file path of of image that represents robot.
	 * @param position where robot starts.
	 * @param flags that robot should reach in the game.
	 */
	public Robot(String texturePath, Vector2 position, Flag[] flags) {
		this.texturePath = texturePath;
		this.flags = Board.getFlags();
		this.position = position;
		this.direction = RobotDirection.NORTH;
		this.currentGoal = flags[0];
	}

	/**
	 * Creates a robot that can move and capture flags in the game.
	 * @param texturePath	The texture path for the robot.
	 * @param position		The start position of the robot.
	 */
	public Robot(String texturePath, Vector2 position) {
		this.texturePath = texturePath;
		this.position = position;

		flags = Board.getFlags();
		this.direction = RobotDirection.NORTH;

		// Change this so that the robot only has "Current Goal"
		this.currentGoal = flags[0];
	}

	/**
	 * Creates a robot. Used for testing purpose.
	 * Robot movement and flag testing is done manual.
	 * @param position of robot.
	 */
	public Robot(Vector2 position) {
		this.position = position;
		this.direction = RobotDirection.NORTH;
	}

	public void render(Batch batch, AssetManager assetManager) {
		if (!assetManager.isLoaded(texturePath)) {
			assetManager.finishLoadingAsset(texturePath);
		}

		Texture robotTexture = assetManager.get(texturePath);

		switch (this.direction) {
			case SOUTH:
				batch.draw(new TextureRegion(robotTexture), position.x, position.y, 0.5f, 0.5f, 1f, 1f, 1f, 1f, 180);
				break;
			case EAST:
				batch.draw(new TextureRegion(robotTexture), position.x, position.y, 0.5f, 0.5f, 1f, 1f, 1f, 1f, 270);
				break;
			case WEST:
				batch.draw(new TextureRegion(robotTexture), position.x, position.y, 0.5f, 0.5f, 1f, 1f, 1f, 1f, 90);
				break;
			case NORTH:
				batch.draw(new TextureRegion(robotTexture), position.x, position.y, 0.5f, 0.5f, 1f, 1f, 1f, 1f, 0);
				break;
			default:
				break;
		}
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setRelativePosition(int x, int y) {
		if (position.x + x < 12 && position.y + y < 12 && position.x + x >= 0 && position.y + y >= 0){
			position.x += x;
			position.y += y;
		}
		else {
			setActive(false);
		}
	}

	public void registerMove(ProgrammingCard card) {
		if (card == null || card.getCardType() == ProgrammingCardType.AGAIN)
			return;
		lastCard = card;
	}

	public ProgrammingCard getMove() {
		return lastCard;
	}

	public RobotDirection getDirection() {
		return direction;
	}

	public void setDirection(RobotDirection direction) {
		this.direction = direction;
	}

	public void dispose() {
	}

	public Flag getCurrentGoal() {
		return currentGoal;
	}

	public int getFlagsVisited() {
		return flagsVisited;
	}

	public void setFlagsVisited(int flagsVisited) {
		this.flagsVisited = Math.min(flagsVisited, flags.length);
	}

	public void setCurrentGoal(Flag currentGoal) {
		if (currentGoal.getLevel() <= flags.length){
			this.currentGoal = currentGoal;
		}

	}

	public void setRelativeHP(int hp) {
		if (this.hp <= 0) {
			setAlive(false);
			return;
		}
		if (this.hp > 10) {
			this.hp = 10;
			return;
		}
		this.hp += hp;
	}

	public int getHp() { return this.hp; }

	public void setAlive(Boolean alive) {
		isAlive = alive;
		if (alive) {
			System.out.println("The Robot is dead");
			setRelativePosition(-3,-3);
		}
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getTexturePath() {
		return texturePath;
	}
}
