package inf112.ingenting.roborally.cards;

import inf112.ingenting.roborally.board.MoveType;

import static inf112.ingenting.roborally.board.MoveType.FORWARD;

/**
 * Enum for types of cards
 *
 * A list of moves corresponding to the enum value can be returned
 * by the <code>getMoves</code> function.
 *
 * The <code>getPriority</code> function will most likely be removed
 * in a later version of the program, but for now it is used for
 * testing purposes.
 */
public enum ProgrammingCardType {
	MOVE_1(FORWARD),
	MOVE_2(FORWARD, FORWARD),
	MOVE_3(FORWARD, FORWARD, FORWARD),
	ROTATE_RIGHT(MoveType.ROTATE_RIGHT),
	ROTATE_LEFT(MoveType.ROTATE_LEFT),
	BACKUP(MoveType.BACKUP),
	AGAIN;

	private final MoveType[] moves;

	ProgrammingCardType(MoveType ... moves) {
		this.moves = moves;
	}

	public MoveType[] getMoves() {
		return moves;
	}
}
