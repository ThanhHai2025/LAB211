package model;

/**
 * Abstract class representing a general shape.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public abstract class Shape {

    /**
     * Calculates the perimeter of the shape.
     *
     * @return the perimeter of the shape.
     */
    public abstract double getPerimeter();

    /**
     * Calculates the area of the shape.
     *
     * @return the area of the shape.
     */
    public abstract double getArea();

    /**
     * Displays the information of the shape.
     */
    public abstract void printResult();
}
