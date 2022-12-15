package Model;
import View.*;

public class Model {
    int width;
    int height;

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
    }

    public Shape[] getShapes() {
        Point[] points = {new Point(5,5)};
        return (Shape[])points;
    }
}
