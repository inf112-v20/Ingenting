package inf112.ingenting.roborally.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import inf112.ingenting.roborally.board.MoveType;

import java.util.Random;

public class ProgrammingCard extends Actor {
	private ProgrammingCardType type;
	private int priority;
	float width, height;
	Sprite cardSprite;

	/**
	 * Constructs class and randomly chooses a Programming Card Type & priority
	 */
	public ProgrammingCard() {
		Random rand = new Random();

		// ew
		this.type = ProgrammingCardType.values()[rand.nextInt(ProgrammingCardType.values().length)];
		this.priority = rand.nextInt(500) + 100;
	}

	/**
	 * Constructs class & randomly chooses a priority
	 *
	 * @param type	The card type
	 */
	public ProgrammingCard(ProgrammingCardType type) {
		this.type = type;
		this.priority = new Random().nextInt(500) + 100;

		// Testing to get the image to each programming card
		System.out.println(type.name() + ".png");
		cardSprite = new Sprite(new Texture(Gdx.files.internal(type.name() + ".png")));
		this.width = cardSprite.getWidth();
		this.height = cardSprite.getHeight();
	}

	/**
	 * Constructs class with given card type and priority
	 *
	 * @param type		The card type
	 * @param priority	The priority
	 */
	public ProgrammingCard(ProgrammingCardType type, int priority) {
		this.type = type;
		this.priority = priority;
	}

	/**
	 * Returns the <code>ProgrammingCardType</code>
	 *
	 * @return The card type
	 */
	public ProgrammingCardType getCardType() {
		return type;
	}

	/**
	 * Sets the card type
	 *
	 * @param type The card type
	 */
	public void setCardType(ProgrammingCardType type) {
		this.type = type;
	}

	/**
	 * Returns a list of moves associated with the card type
	 *
	 * @return A list of moveTypes
	 */
	public MoveType[] getMoves() {
		return type.getMoves();
	}

	/**
	 * Returns the card's priority
	 *
	 * @return The priority in integer format
	 */
	public int getPriority() {
		return priority;
	}


	/**
	 * Sets the card's priority
	 *
	 * @param priority The priority to set the card to
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
