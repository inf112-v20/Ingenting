package inf112.ingenting.roborally.element;

public class Flag extends Element {

	private final Integer level;

	/**
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
