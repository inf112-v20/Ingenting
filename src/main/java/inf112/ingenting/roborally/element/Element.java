/**
 * Implementation of <code>IElement</code>.
 *
 * @author Ayoub Tammaoui
 * @see IElement
 */

package inf112.ingenting.roborally.element;

public class Element implements IElement {

	private int x;
	private int y;

	/**
	 * Create a element that exists on map.
	 * Every element as a position, cell and a layer.
	 * @param x position
	 * @param y position
	 */
	public Element(int x, int y) {
		this.y = y;
		this.x = x;
	}

	@Override
	public int getXPosition() {
		return x;
	}

	@Override
	public int getYPosition() {
		return y;
	}

}
