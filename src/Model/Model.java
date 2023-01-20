package Model;
import View.*;

import java.util.Arrays;

public class Model {
    int width;
    int height;
    Point[] points = {new Point(1, 1), new Point(2, 1), new Point(1, 2), new Point(2, 2), new Point(5,5), new Point(6, 5), new Point(7, 5)};

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
        int[] die = new int[points.length];
        int o = 0;
        int p;
        for (int i = 0; i < points.length; i++) {
            //System.out.println(oldArr[i] + " has " + getNeighbor(oldArr, oldArr[i]) + " neighbors");
            // game of life death rule
            if (getNeighbor(points, points[i]) < 2 || getNeighbor(points, points[i]) > 3) {
                //delete point[i]
                die[o] = i;
                o++;
                //i--;
            }
            //for reproduction: points.add(new Point(x, y));
            if (checkNeighbor(width, height, points) == 3) {

            }
        }
        for (int i = 0; i < die.length; i++) {
            //remove pixel on position at die from loop above, p becomes position as int
            p = die[i];
            System.out.println(p);
            points = removeTheElement(points, p);
            //die = removeTheIntElement(die, p);
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
            neighbor = 0;
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

    public static int[] removeTheIntElement(int[] arr, int index)
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
        int[] anotherArray = new int[arr.length - 1];

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
