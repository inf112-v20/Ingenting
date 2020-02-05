package inf112.skeleton.app.object;

public class Object implements IObject {
    private int width = 64;
    private int height = 64;
    private int rotation = 0;
    private ObjectType type;
    private int x;
    private int y;

    /**
     * Create a drawable object that will be drawn on the board.
     * @param width of the object. Default is 64.
     * @param height of the object Default is 64.
     * @param rotation of the object. Default is 0.
     * @param type of the object, for example Wall.
     * @param x position of the object.
     * @param y position of the object.
     */
    public Object(int width, int height, int rotation, ObjectType type, int x, int y){
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Create a drawable object with a default width and height of 64.
     * @param x position
     * @param y positon
     * @param type of the object for example ROBOT.
     */
    public Object(int x, int y, ObjectType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }


    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return  x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setRotation(int rot) {
        this.rotation = rot;
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    @Override
    public void setTexture(ObjectType type) {
        this.type = type;
    }

    @Override
    public ObjectType getTexture() {
        return type;
    }
}
