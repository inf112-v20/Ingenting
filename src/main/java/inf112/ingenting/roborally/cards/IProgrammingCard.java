package inf112.ingenting.roborally.cards;

import inf112.ingenting.roborally.board.MoveType;

public interface IProgrammingCard {

	/**
	 * Returns the <code>ProgrammingCardType</code>
	 *
	 * @return The card type
	 */
	ProgrammingCardType getCardType();

	/**
	 * Sets the card type
	 *
	 * @param type The card type
	 */
	void setCardType(ProgrammingCardType type);

	/**
	 * Returns a list of moves associated with the card type
	 *
	 * @return A list of moveTypes
	 */
	MoveType[] getMoves();

	/**
	 * Returns the card's priority
	 *
	 * @return The priority in integer format
	 */
	int getPriority();

	/**
	 * Sets the card's priority
	 *
	 * @param priority The priority to set the card to
	 */
	void setPriority(int priority);
}
