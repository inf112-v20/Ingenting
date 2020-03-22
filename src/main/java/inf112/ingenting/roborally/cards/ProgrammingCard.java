package inf112.ingenting.roborally.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.ingenting.roborally.board.MoveType;

import java.util.Random;

public class ProgrammingCard extends Actor {
	private ProgrammingCardType type;
	private int priority;
	float width, height;
	Texture cardTexture;
	private ImageTextButton.ImageTextButtonStyle style;
	private Skin skin;

	/**
	 * Constructs class and randomly chooses a Programming Card Type & priority
	 */
	public ProgrammingCard() {
		Random rand = new Random();

		// ew
		this.type = ProgrammingCardType.values()[rand.nextInt(ProgrammingCardType.values().length)];
		this.priority = rand.nextInt(500) + 100;

		System.out.println(type.name() + ".png");
	}

	/**
	 * Constructs class & randomly chooses a priority
	 *
	 * @param type	The card type
	 */
	public ProgrammingCard(ProgrammingCardType type) {
		this.type = type;
		this.priority = new Random().nextInt(500) + 100;

		System.out.println(type.name() + ".png");
		cardTexture = new Texture(Gdx.files.internal(type.name() + ".png"));
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
	 * Returns the sprite associated with the card type
	 *
	 * @return a sprite
	 */
	public Texture getCardTexture() {
		return cardTexture;
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

	/**
	 * Sets up the skin to the programing card
	 */
	public void setUpSkin() {
		skin = new Skin();
		skin.add("MOVE_3", new Texture("MOVE_3.png"));
		skin.add("MOVE_1", new Texture("MOVE_1.png"));
		skin.add("MOVE_2", new Texture("MOVE_2.png"));
		skin.add("ROTATE_RIGHT", new Texture("ROTATE_RIGHT.png"));
		skin.add("ROTATE_LEFT", new Texture("ROTATE_LEFT.png"));
		skin.add("BACKUP", new Texture("BACKUP.png"));
		skin.add("AGAIN", new Texture("AGAIN.png"));
		style = new ImageTextButton.ImageTextButtonStyle();
		style.up = skin.getDrawable(getCardType().name());
	}

	/**
	 * Return the programming card style
	 *
	 * @return the programmingcard style
	 */
	public ImageTextButton.ImageTextButtonStyle getStyle() {
		return this.style;
	}

	public void dispose() {
		skin.dispose();
	}
}
