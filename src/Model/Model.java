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
            //int neighbor = checkNeighbor(width, height, points);
            int neighbor = getNeighbor(points);
        }
    }

    public int checkNeighbor(int width, int height, Point[] points) {
        int neighbor = 0;
        int y;
        int x;

        for (int i = 0; i < points.length; i++) {
            y = i;
            x = 1;
            for (int o = 2; o < width; o++) {
                if (x - points[i].getX() <= 1 && x - points[i].getX() >= -1 && y - points[i].getY() <= 1 && y - points[i].getY() >= -1) {
                    neighbor++;
                }
                x = o;
            }
            System.out.println("Position " + (i+1) + " has " + neighbor + " neighbors");
        }

        return neighbor;
    }

    public int getNeighbor(Point[] points) {
        int neighbor = -1;

        for (int x = 0; x < points.length; x++) {
            for (int i = 0; i < points.length; i++) {
                if (points[x].getX() - points[i].getX() <= 1 && points[x].getX() - points[i].getX() >= -1 && points[x].getY() - points[i].getY() <= 1 && points[x].getY() - points[i].getY() >= -1) {
                    neighbor++;
                }
            }
            System.out.println("Position " + (x+1) + " has " + neighbor + " neighbors");
            if (neighbor < 2 || neighbor > 3) {
                //delete point[x]
            }
            //for reproduction: points.add(new Point(x, y));
            neighbor = -1;
        }
        return neighbor;
    }

    public Shape[] getShapes() {
        Point[] points = {new Point(5,5), new Point(1, 1), new Point(6, 5), new Point(7, 5)};
        return (Shape[])points;
    }

    public Point[] getPoints() {
        Point[] points = {new Point(1, 1), new Point(5,5), new Point(6, 5), new Point(7, 5)};
        return points;
    }
}
