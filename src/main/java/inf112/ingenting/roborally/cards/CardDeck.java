package inf112.ingenting.roborally.cards;

import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class CardDeck {
	public static final int DEFAULT_DECK_SIZE = 50,
		DEFAULT_LOWEST_PRIORITY = 100,
		DEFAULT_HIGHEST_PRIORITY = 300;

	private Map<ProgrammingCardType, Integer> cardWeights;
	private Array<ProgrammingCard> cards;
	private int lowestPriority, highestPriority;
	private int deckSize;

	public CardDeck() {
		this(DEFAULT_DECK_SIZE);
	}

	public CardDeck(int deckSize) {
		this(deckSize, DEFAULT_LOWEST_PRIORITY, DEFAULT_HIGHEST_PRIORITY);
	}

	public CardDeck(int deckSize, int lowestPriority, int highestPriority) {
		cardWeights = new HashMap<>();
		for (ProgrammingCardType t : ProgrammingCardType.values()) {
			cardWeights.put(t, 1);
		}

		this.deckSize = deckSize;
		this.lowestPriority = lowestPriority;
		this.highestPriority = highestPriority;
		cards = new Array<>();

		generateDeck();
	}

	public Array<ProgrammingCard> generateDeck() {
		// Delete old deck before creating a new one
		cards.clear();

		int totalWeight = 0;
		for (Integer w : cardWeights.values())
			totalWeight += w;

		for (int i = 0; i < deckSize; i++) {
			double r = Math.random() * totalWeight;
			double count = 0.0;

			// Weighted add
			for (Map.Entry<ProgrammingCardType, Integer> entry : cardWeights.entrySet()) {
				count += entry.getValue();

				if (count >= r) {
					ProgrammingCard card = new ProgrammingCard(entry.getKey());
					card.setPriority((int) (Math.random() * (highestPriority - lowestPriority) + lowestPriority));

					cards.add(card);
					break;
				}
			}

		}

		return cards;
	}

	public CardDeck setCardWeight(int weight, ProgrammingCardType ... types) {
		for (ProgrammingCardType type : types)
			cardWeights.put(type, weight);

		return this;
	}

	public int getCardWeight(ProgrammingCardType type) {
		return cardWeights.get(type);
	}

	public Array<ProgrammingCard> getDeck() {
		return cards;
	}

	public void shuffleDeck() {
		cards.shuffle();
	}

	public Array<ProgrammingCard> getDeckShuffled() {
		shuffleDeck();
		return cards;
	}

	public void setPriority(int lower, int higher) {

	}
}
