package model;

/**
 * Triangle class presents a triangle.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public class Triangle extends Shape {

    /**
     * The first side of the triangle.
     */
    private double sideA;

    /**
     * The second side of the triangle.
     */
    private double sideB;

    /**
     * The third side of the triangle.
     */
    private double sideC;

    /**
     * Creates a triangle with three specified sides.
     *
     * @param sideA the first side
     * @param sideB the second side
     * @param sideC the third side
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Gets the first side of the triangle.
     *
     * @return side A
     */
    public double getSideA() {
        return sideA;
    }

    /**
     * Gets the second side of the triangle.
     *
     * @return side B
     */
    public double getSideB() {
        return sideB;
    }

    /**
     * Gets the third side of the triangle.
     *
     * @return side C
     */
    public double getSideC() {
        return sideC;
    }

    /**
     * Calculates the perimeter of the triangle.
     *
     * @return the perimeter of the triangle
     */
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     *
     * @return the area of the triangle
     */
    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Checks whether the three sides can form a valid triangle.
     *
     * @return true if the triangle is valid; otherwise false
     */
    public boolean isValid() {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA;
    }

    /**
     * Displays the information of the triangle.
     */
    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.printf("Area: %.4f%n", getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
