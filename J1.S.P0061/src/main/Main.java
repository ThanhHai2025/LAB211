package main;

import controller.ShapeController;

/**
 * Main class used to run the Shape Calculator program.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public class Main {

    public static void main(String[] args) {
        // Step 1: Create the ShapeController object.
        ShapeController shapeController = new ShapeController();

        // Step 2: Run the Shape Calculator program.
        shapeController.run();
    }
}
