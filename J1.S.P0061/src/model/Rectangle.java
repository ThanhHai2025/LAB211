package model;

/**
 * Rectangle class presents a rectangle.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public class Rectangle extends Shape {

    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * The length of the rectangle.
     */
    private double length;

    /**
     * Creates a rectangle with the specified width and length.
     *
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the length of the rectangle.
     *
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * Displays the information of the rectangle.
     */
    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
