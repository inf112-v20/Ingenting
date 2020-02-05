package inf112.skeleton.app.board;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.utils.Array;

public interface IBoard {
	// Rendering functions
	void Render();
	void Render(BoardLayer layer);

	// Get position
	Array<Cell> getPos(Vector2 pos);
	Array<Cell> getPos(int x, int y);

	// Get element in given position
	//	Returns null if there is no element in given position
	Element getElement(Vector2 pos);
	Element getElement(int x, int y);

	boolean moveElement(Element elem, Move direction);

	// Attempt to place an element in given position.
	//	Returns true if successful,
	//	false if there is something in the way
	boolean setElement(Element elem, Vector2 pos);
	boolean setElement(Element elem, int x, int y);
}
