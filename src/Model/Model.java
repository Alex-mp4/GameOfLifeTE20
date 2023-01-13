package Model;
import View.*;

public class Model {
    int width;
    int height;
    Point[] points = {new Point(1, 1), new Point(5,5), new Point(6, 5), new Point(7, 5)};

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
        for (int i = 0; i < points.length; i++) {
            //int neighbor = checkNeighbor(width, height, points);
            System.out.println(points[i] + " has " + getNeighbor(points, points[i]) + " neighbors");
            // game of life death rule
            if (getNeighbor(points, points[i]) < 2 || getNeighbor(points, points[i]) > 3) {
                //delete point[i]
                points = removeTheElement(points, i);
                // i--;
            }
            //for reproduction: points.add(new Point(x, y));
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

    public int getNeighbor(Point[] points, Point point) {
        int neighbor = -1;
            for (int i = 0; i < points.length; i++) {
                // check all the spaces around the pixel, including itself
                if (point.getX() - points[i].getX() <= 1 && point.getX() - points[i].getX() >= -1 && point.getY() - points[i].getY() <= 1 && point.getY() - points[i].getY() >= -1) {
                    neighbor++;
                }
            }
        return neighbor;
    }

    public Shape[] getShapes() {
        Point[] points = getPoints();
        return (Shape[])points;
    }

    public Point[] getPoints() {
        return points;
    }

    public static Point[] removeTheElement(Point[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        Point[] anotherArray = new Point[arr.length - 1];

        // Copy the elements from starting till index
        // from original array to the other array
        System.arraycopy(arr, 0, anotherArray, 0, index);

        // Copy the elements from index + 1 till end
        // from original array to the other array
        System.arraycopy(arr, index + 1,
                anotherArray, index,
                arr.length - index - 1);

        // return the resultant array
        return anotherArray;
    }
}
