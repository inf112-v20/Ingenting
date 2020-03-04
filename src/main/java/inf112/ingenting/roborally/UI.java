package inf112.ingenting.roborally;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.ingenting.roborally.cards.ProgrammingCard;

public class UI extends ApplicationAdapter {

	private Stage stage;

	@Override
	public void render()
	{
		stage.draw();
	}

	public void create()
	{

	}

	public void createHand()
	{
		Stage stage = new Stage(new ScreenViewport());

		// Should be the cards selected from the deck
		int totalCards = 5;
		//CardActor[] deck = new CardActor[totalCards];
		HorizontalGroup hand = new HorizontalGroup();

		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		int cardWidth = screenWidth / 10;
		int cardHeight = cardWidth * 2;

		hand.setBounds(screenWidth/2, -screenHeight/4, Gdx.graphics.getWidth()-cardWidth, Gdx.graphics.getHeight());
		hand.space(screenWidth / -3f);
		hand.align(Align.bottom | Align.center);

		int startX = (screenWidth/2 - cardWidth/2);
		int startXOffset = cardWidth / 2;

		// for each card > 1 the startX must move to the left by half a card
		if (totalCards > 1) {
			startXOffset = cardWidth / 2 * totalCards;
		}
		// Then for each other card it's x value on screen is the [startX + cardWidth / 2]

		for (int i = 0; i < totalCards; i++) {
			//deck[i] =  new CardActor(new ProgrammingCard());
			//hand.addActor(deck[i]);
			//deck[i].setX(startX - startXOffset * (totalCards - i));
		}
		stage.addActor(hand);
	}

	// TODO Table on the right with checkbox, disapear after selected 5

	// TODO Table on the bottom with selected cards

	// TODO Make programming card an Actor
}
