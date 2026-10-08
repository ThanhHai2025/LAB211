package model;

/**
 * Circle class presents a circle.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public class Circle extends Shape{

    /**
     * The radius of the circle.
     */
    private double radius;

    /**
     * Creates a circle with the specified radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    
    /**
     * Gets the radius of the circle.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculates the perimeter of the circle.
     *
     * @return the perimeter of the circle
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return the area of the circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Displays the information of the circle.
     */
    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}

