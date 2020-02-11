package inf112.ingenting.roborally.player;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.board.BoardLayerType;
import inf112.ingenting.roborally.board.MoveType;
import inf112.ingenting.roborally.cards.CardType;
import inf112.ingenting.roborally.element.Element;
import inf112.ingenting.roborally.element.ElementType;

public class Robot extends Element {

    private boolean isActive = true;
    private int health = 3;
    private PlayerDirection direction = PlayerDirection.NORTH;

    /**
     * Create a Robot with a default width and height of 64.
     * @param x position
     * @param y positon
     */
    public Robot(int x, int y, TiledMapTileLayer.Cell cell, BoardLayerType layer)
    {
        super(x, y, ElementType.ROBOT, cell, layer);
    }

    public Robot(){
        super(0, 0, ElementType.ROBOT, BoardLayerType.INTERACTABLE);
    }

    public void move(CardType card, Board board){
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

    public void setDirection(PlayerDirection direction) {
        this.direction = direction;
    }
}
