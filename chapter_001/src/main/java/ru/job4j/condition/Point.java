package ru.job4j.condition;
/**
 * Point
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.13
 */
public class Point {
    /**
     * x-coordinate
     */
    private int x;
    /**
     * y-coordinate
     */
    private int y;

    /**
     * constructor
     * @param x coordinate
     * @param y coordinate
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param that point
     * @return distance
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(5, 7);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
