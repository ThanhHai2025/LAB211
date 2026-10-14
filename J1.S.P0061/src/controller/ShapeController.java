package controller;

import java.util.Scanner;
import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;

/**
 * ShapeController class the input and display process of the Shape Calculator
 * program.
 *
 * @version 14/10/2026
 * @author HaiNT
 */
public class ShapeController {

    /**
     * Scanner used to read input from the keyboard.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Gets a positive double value from the user.
     *
     * @param message the message displayed before input
     * @return a positive double value
     */
    public double getDouble(String message) {

        // Keep asking until the user enters a valid positive number.
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    return value;
                }
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number.");
            }
        }
    }

    /**
     * Checks whether the three sides can form a valid triangle.
     *
     * @return true if the triangle is valid; otherwise false
     */
    private boolean isTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA;
    }

    /**
     * Runs the Shape Calculator program.
     */
    public void run() {
        System.out.println("=====Calculator Shape Program=====");
        double width = getDouble("Please input side width of Rectangle: ");
        double length;
        while (true) {
            length = getDouble("Please input length of Rectangle: ");
            if (length >= width) {
                break;
            }
            System.err.println("Length must be greater than width.");
        }

        double radius = getDouble("Please input radius of Circle: ");

        double sideA;
        double sideB;
        double sideC;

        while (true) {
            sideA = getDouble("Please input side A of Triangle: ");
            sideB = getDouble("Please input side B of Triangle: ");
            sideC = getDouble("Please input side C of Triangle: ");
            if (isTriangle(sideA, sideB, sideC)) {
                break;
            }
            System.err.println("Invalid triangle! Please re-input.");
        }

        //Declare available shapes to demonstrate polymorphism.
        Shape shape;
        //Assign the Rectangle object and display result.
        shape = new Rectangle(width, length);
        shape.printResult();

        //Assign the Circle object and display result.
        shape = new Circle(radius);
        shape.printResult();

        //Assign the Triangle object and display result.
        shape = new Triangle(sideA, sideB, sideC);
        shape.printResult();
    }
}
