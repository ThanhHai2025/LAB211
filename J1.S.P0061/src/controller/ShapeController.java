package controller;

import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;
import utils.Validation;

/**
 * ShapeController class the input and display process of the Shape Calculator
 * program.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public class ShapeController {

    /**
     * Object used to validate user input.
     */
    private Validation validation = new Validation();

    /**
     * Runs the Shape Calculator program.
     */
    public void run() {

        // Step 1: Display the program title.
        System.out.println("=====Calculator Shape Program=====");

        // Step 2: Input data and create a Rectangle.
        Shape rectangle = inputRectangle();

        // Step 3: Input data and create a Circle.
        Shape circle = inputCircle();

        // Step 4: Input data and create a Triangle.
        Shape triangle = inputTriangle();

        // Step 5: Display the results of all shapes.
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    /**
     * Inputs the width and length and creates a Rectangle.
     *
     * @return a Rectangle object stored as a Shape reference
     */
    private Shape inputRectangle() {

        double width = validation.inputPositiveDouble("Please input side width of Rectangle: ");
        double length;

        // Keep asking until the length is greater than the width.
        while (true) {
            length = validation.inputPositiveDouble("Please input length of Rectangle: ");
            if (length > width) {
                break;
            }
            System.out.println("Length must be greater than width.");
        }
        return new Rectangle(width, length);
    }

    /**
     * Inputs the radius and creates a Circle.
     *
     * @return a Circle object stored as a Shape reference
     */
    private Shape inputCircle() {
        double radius = validation.inputPositiveDouble("Please input radius of Circle: ");
        return new Circle(radius);
    }

    /**
     * Inputs three sides and creates a valid Triangle.
     *
     * @return a valid Triangle object stored as a Shape reference
     */
    private Shape inputTriangle() {
        
        // Keep asking until three side of triangle is valid.
        while (true) {
            double sideA = validation.inputPositiveDouble("Please input side A of Triangle: ");
            double sideB = validation.inputPositiveDouble("Please input side B of Triangle: ");
            double sideC = validation.inputPositiveDouble("Please input side C of Triangle: ");
            Triangle triangle = new Triangle(sideA, sideB, sideC);

            // Check whether the three sides can form a valid triangle.
            if (triangle.isValid()) {
                return triangle;
            }
            System.out.println("Invalid triangle! Please re-input.");
        }
    }
}
