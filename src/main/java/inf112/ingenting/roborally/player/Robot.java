package inf112.ingenting.roborally.player;

import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.MoveType;
import inf112.ingenting.roborally.element.Element;
import inf112.ingenting.roborally.element.ElementType;

public class Robot extends Element {

    private Board board;

    private boolean isActive = true;
    private int health = 3;

    /**
     * Create a Robot with a default width and height of 64.
     * @param x position
     * @param y positon
     * @param board game where player can move around and interact with objects.
     */
    public Robot(int x, int y, Board board)
    {
        super(x, y, ElementType.ROBOT);
        this.board = board;
    }

    public void move(){
        // TODO: Add movement logic.
    }

    public int getHealth(){
        return health;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public boolean isActive() {
        return isActive;
    }
}
