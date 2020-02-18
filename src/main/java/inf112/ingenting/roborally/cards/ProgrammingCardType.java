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
	MOVE_1_P1(FORWARD, 630),
	MOVE_1_P2(FORWARD, 550),
	MOVE_2(new MoveType[]{FORWARD, FORWARD}, 740),
	MOVE_3(new MoveType[]{FORWARD, FORWARD, FORWARD}, 840),
	ROTATE_RIGHT_P1(MoveType.ROTATE_RIGHT, 400),
	ROTATE_RIGHT_P2(MoveType.ROTATE_RIGHT, 260),
	ROTATE_RIGHT_P3(MoveType.ROTATE_RIGHT, 120),
	ROTATE_LEFT_P1(MoveType.ROTATE_LEFT, 300),
	ROTATE_LEFT_P2(MoveType.ROTATE_LEFT, 240),
	ROTATE_LEFT_P3(MoveType.ROTATE_LEFT, 100);

	private final MoveType[] moves;
	private final int priority;

	ProgrammingCardType(MoveType move, int priority) {
		this.moves = new MoveType[]{move};
		this.priority = priority;
	}

	ProgrammingCardType(MoveType[] moves, int priority) {
		this.moves = moves;
		this.priority = priority;
	}

	public MoveType[] getMoves() {
		return moves;
	}

	public int getPriority() {
		return priority;
	}
}
