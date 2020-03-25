package inf112.ingenting.roborally.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;

import java.util.ArrayList;

public class Robot {
	private ArrayList<TiledMapTileLayer.Cell> flags;
	private Vector2 position;
	private RobotDirection direction;
	private ProgrammingCard lastCard;

	private Texture robotTexture;



	//private TextureRegion textureRegion = new TextureRegion(robotTexture);

	public void checkFlag(TiledMapTileLayer layer) {
		//TODO
		// for cell; if flag{
		//this.flags.add(flag);
		//}
	}

	public Robot(String texturePath, Vector2 position) {
		robotTexture = new Texture(texturePath);

		this.position = position;
		direction = RobotDirection.NORTH;
	}

	public Robot(Vector2 position) {
		this.position = position;
		direction = RobotDirection.NORTH;
	}

	public void render(Batch batch) {
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
