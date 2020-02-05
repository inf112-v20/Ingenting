package inf112.skeleton.app;

import inf112.skeleton.app.object.Object;
import inf112.skeleton.app.object.ObjectType;

public class Robot extends Object {

    private int xPosition;
    private int yPosition;
    private int HP = 3;
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

    public int getHP(){
        return HP;
    }

    public boolean isActive(){
        if(HP <= 0){
            return false;
        }
        return true;
    }




}
