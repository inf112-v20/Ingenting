package inf112.ingenting.roborally.player;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.BoardLayerType;
import inf112.ingenting.roborally.board.MoveType;
import inf112.ingenting.roborally.cards.CardType;
import inf112.ingenting.roborally.element.Element;
import inf112.ingenting.roborally.element.ElementType;

public class Robot extends Element {

    private Board board;
    private boolean isActive = true;
    private int health = 3;
    private PlayerDirection direction;

    /**
     * Create a Robot with a default width and height of 64.
     * @param x position
     * @param y positon
     * @param board game where player can move around and interact with objects.
     */
    public Robot(int x, int y, Board board, TiledMapTileLayer.Cell cell, BoardLayerType layer)
    {
        super(x, y, ElementType.ROBOT, cell, layer);
        this.board = board;
        this.direction = PlayerDirection.NORTH;
    }

    public void move(CardType card){
        // TODO: Add movement logic.
        for (MoveType move: card.getMoves()) {
            board.moveRobot(this, move);
        }
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

    public PlayerDirection getDirection() {
        return direction;
    }
}
