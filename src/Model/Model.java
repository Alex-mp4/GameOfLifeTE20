package Model;
import View.*;

public class Model {
    int width;
    int height;

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            checkNeighbor(width, height, points);
        }
    }

    public int checkNeighbor(int width, int height, Point[] points) {
        int neighbor = 0;
        int y;
        int x;

        for (int i = 0; i < height; i++) {
            y = i;
            x = 1;
            for (int o = 0; o < width; o++) {

                if (x - points[i].getX() <= 1 && x - points[i].getX() >= -1 && y - points[i].getY() <= 1 && y - points[i].getY() >= -1 ) {
                    neighbor++;
                }
            }
        }

        return neighbor;
    }

    public Shape[] getShapes() {
        Point[] points = {new Point(5,5)};
        return (Shape[])points;
    }

    public Point[] getPoints() {
        Point[] points = {new Point(5,5)};
        return points;
    }
}
