/**
 * Implementation of <code>IElement</code>.
 *
 * @author Ayoub Tammaoui
 * @see IElement
 */

package inf112.ingenting.roborally.element;

public class Element implements IElement {

	private int xPosition;
	private int yPosition;

	/**
	 * Create a element that exists on map.
	 * Every element as a position, cell and a layer.
	 * @param x position
	 * @param y position
	 */
	public Element(int x, int y) {
		this.yPosition = y;
		this.xPosition = x;
	}

	@Override
	public int getXPosition() {
		return xPosition;
	}

	@Override
	public int getYPosition() {
		return yPosition;
	}

}
