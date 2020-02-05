package inf112.skeleton.app;

public class Object implements IObject {
    private int width = 64;
    private int height = 64;
    private int rotation = 0;
    private ObjectType type;
    private int xPos;
    private int yPos;

    /**
     * Create a drawable object with a default width and height of 64.
     * @param x position
     * @param y positon
     * @param type of the object for example ROBOT.
     */
    public Object(int x, int y, ObjectType type) {
        this.xPos = x;
        this.yPos = y;
        this.type = type;
    }


    @Override
    public int getX() {
        return  xPos;
    }

    @Override
    public int getY() {
        return yPos;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    @Override
    public ObjectType getType() {
        return type;
    }
}
