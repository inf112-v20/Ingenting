package inf112.ingenting.roborally.element;

public interface IElement {
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

    void setType(ElementType type);

    ElementType getType();
}
