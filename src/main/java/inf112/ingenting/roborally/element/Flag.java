package inf112.ingenting.roborally.element;

public class Flag extends Element {

	private final Integer level;

	/**
	 * Create a flag that has a level. Level represents the order
	 * the flag should be reached in. For example: 1 => First flag to reach.
	 * @param x position.
	 * @param y position.
	 * @param level of flag. Represents in which order it is to be reached.
	 */
	public Flag(int x, int y,  Integer level) {
		super(x, y);
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}
}
