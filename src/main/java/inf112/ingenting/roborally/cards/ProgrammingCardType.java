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
	MOVE_1("MOVE 1", FORWARD),
	MOVE_2("MOVE 2", FORWARD, FORWARD),
	MOVE_3("MOVE 3", FORWARD, FORWARD, FORWARD),
	ROTATE_RIGHT("ROTATE RIGHT", MoveType.ROTATE_RIGHT),
	ROTATE_LEFT("ROTATE LEFT", MoveType.ROTATE_LEFT),
	BACKUP("BACK UP", MoveType.BACKUP),
	AGAIN("REPEAT");

	private final String name;
	private final MoveType[] moves;

	ProgrammingCardType(String name, MoveType ... moves) {
		this.name = name;
		this.moves = moves;
	}

	public MoveType[] getMoves() {
		return moves;
	}
	public String getName() {
		return name;
	}
}
