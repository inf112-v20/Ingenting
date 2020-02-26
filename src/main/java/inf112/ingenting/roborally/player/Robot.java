package inf112.ingenting.roborally.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;

public class Robot {
	private Vector2 position;
	private RobotDirection direction;
	private ProgrammingCard lastCard;

	private Texture robotTexture;

	public Robot(String texturePath, Vector2 position) {
		robotTexture = new Texture(texturePath);

		this.position = position;
		direction = RobotDirection.WEST;
	}

	public void render(Batch batch) {
		batch.draw(robotTexture, position.x, position.y, 1f, 1f);
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public void setRelativePosition(Vector2 position) {
		this.position.x += position.x;
		this.position.y += position.y;
	}

	public void setRelativePosition(int x, int y) {
		position.x += x;
		position.y += y;
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
		robotTexture.dispose();
	}
}
