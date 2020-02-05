package inf112.ingenting.roborally;

import inf112.ingenting.roborally.object.Object;
import inf112.ingenting.roborally.object.ObjectType;

public class Robot extends Object {

    private int xPosition;
    private int yPosition;
    private int health = 3;
    private boolean isActive = true;

    /**
     * Create a drawable object with a default width and height of 64.
     * @param x position
     * @param y positon
     * @param type of the object for example ROBOT.
     */
    public Robot(int x, int y, ObjectType type) {
        super(x, y, type);
    }

    public int getXPos(){
        return xPosition;
    }

    public int getYPos(){
        return yPosition;
    }

    public int getHealth(){
        return health;
    }

    public boolean isActive(){
        return health > 0;
    }




}
