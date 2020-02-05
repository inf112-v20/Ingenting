package inf112.skeleton.app.object;

public interface IObject {
    void setX(int x);
    int getX();

    void setY(int y);
    int getY();

    void setWidth(int width);
    int getWidth();

    void setHeight(int height);
    int getHeight();

    void setRotation(int rot);
    int getRotation();

    void setTexture(ObjectType type);
    ObjectType getTexture();
}
