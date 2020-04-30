package inf112.ingenting.roborally.cards;

import org.junit.Assert;
import org.junit.Test;

public class CardDeckTest {
	@Test
	public void generate15Cards() {
		CardDeck deck = new CardDeck(15);

		Assert.assertEquals(15, deck.getDeck().size);
	}

	@Test
	public void generate100CardsWithPrioritiesBetween50and100() {
		CardDeck deck = new CardDeck(100, 50, 100);

		Assert.assertEquals(100, deck.getDeck().size);

		for (ProgrammingCard card : deck.getDeck()) {
			Assert.assertTrue(card.getPriority() >= 50);
			Assert.assertTrue(card.getPriority() <= 100);
		}
	}

	@Test
	public void generate1000CardsWhereAgainCardsAreVeryCommon() {
		CardDeck deck = new CardDeck(1000);
		deck.setCardWeight(100, ProgrammingCardType.AGAIN);
		deck.generateDeck();

		int againCount = 0;
		int otherCount = 0;

		for (ProgrammingCard card : deck.getDeck())
			if (card.getCardType() == ProgrammingCardType.AGAIN)
				againCount++;
			else
				otherCount++;

		Assert.assertTrue(againCount > otherCount);
	}

	@Test
	public void generate1000CardsWhereAgainCardsAreVeryRare() {
		CardDeck deck = new CardDeck(1000);
		deck.setCardWeight(100, ProgrammingCardType.values());
		deck.setCardWeight(1, ProgrammingCardType.AGAIN);

		int againCount = 0;
		int otherCount = 0;

		for (ProgrammingCard card : deck.getDeck())
			if (card.getCardType() == ProgrammingCardType.AGAIN)
				againCount++;
			else
				otherCount++;

		Assert.assertTrue(againCount * 5 < otherCount);
	}
}
