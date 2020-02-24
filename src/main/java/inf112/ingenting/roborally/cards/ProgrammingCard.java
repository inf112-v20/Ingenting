package inf112.ingenting.roborally.cards;

import inf112.ingenting.roborally.board.MoveType;

import java.util.Random;

public class ProgrammingCard implements IProgrammingCard {
	private ProgrammingCardType type;
	private int priority;

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

	@Override
	public ProgrammingCardType getCardType() {
		return type;
	}

	@Override
	public void setCardType(ProgrammingCardType type) {
		this.type = type;
	}

	@Override
	public MoveType[] getMoves() {
		return type.getMoves();
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
