package inf112.ingenting.roborally.board;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.element.Element;

public interface IBoard {
	/**
	 * Renders the board.
	 */
	void render();

	/**
	 * Renders a specific layer.
	 *
	 * @param layer	The layer to render
	 */
	void render(BoardLayerType layer);

	/**
	 * Returns the contents of a given tile.
	 *
	 * @param pos	The tile to return
	 * @return 		An array containing all layers of the given position
	 */
	Array<TiledMapTileLayer.Cell> getTile(Vector2 pos);

	/**
	 * Returns the contents of a given tile.
	 *
	 * @param x	The x-coordinate of the tile to return
	 * @param y	The y-coordinate of the tile to return
	 * @return	An array containing all layers of the given position
	 */
	Array<TiledMapTileLayer.Cell> getTile(int x, int y);

	/**
	 * Returns the element in the given position.
	 *
	 * If there is no element in the given position, returns null.
	 *
	 * @param pos	The position to return
	 * @return		<code>Object</code> if an element is found,
	 * 				<code>null</code> otherwise
	 */
	Element getElement(Vector2 pos);

	/**
	 * Returns the element in the given position.
	 *
	 * If there is no element in the given position, returns null.
	 *
	 * @param x	The x-coordinate of the position to return
	 * @param y	The y-coordinate of the position to return
	 * @return	<code>Object</code> if an element is found,
	 * 			<code>null</code> otherwise
	 */
	Element getElement(int x, int y);

	/**
	 * Attempts to move a given element.
	 *
	 * If there is something obstructing the element, it cannot move and will fail.
	 *
	 * @param elem		The element to move
	 * @param direction	The direction in which to move the element
	 * @return			<code>true</code> if moving the element succeeds,
	 * 					<code>false</code> otherwise
	 */
	boolean moveElement(Element elem, MoveType direction);

	/**
	 * Attempts to place an element using it's internal position.
	 *
	 * If there is already an element in the given tile of the same type, the element cannot be placed.
	 *
	 * @param elem	The element to place
	 * @return		<code>true</code> if the element could be placed,
	 * 				<code>false</code> otherwise
	 */
	boolean setElement(Element elem);

	/**
	 * Attempts to place an element in a given position.
	 *
	 * If there is already an element in the given tile of the same type, the element cannot be placed.
	 *
	 * @param elem	The element to place
	 * @param pos	The position in which to place the element
	 * @return		<code>true</code> if the element could be placed,
	 * 				<code>false</code> otherwise
	 */
	boolean setElement(Element elem, Vector2 pos);

	/**
	 * Attempts to place an element in a  given position.
	 *
	 * If there is already an element in the given tile of the same type, the element cannot be placed.
	 *
	 * @param elem	The element to place
	 * @param x		The x-coordinate of the position in which to place the element
	 * @param y		The y-coordinate of the position in which to place the element
	 * @return		<code>true</code> if the element could be placed,
	 * 				<code>false</code> otherwise
	 */
	boolean setElement(Element elem, int x, int y);

	/**
	 * Disposes of internal libglx classes
	 */
	void dispose();
}