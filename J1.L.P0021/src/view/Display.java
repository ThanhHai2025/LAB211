package view;

import controller.StudentManager;
import util.Validation;

/**
 * The Display class handles user interaction by displaying the menu, receiving
 * user input.
 *
 * @version 18/11/206
 * @author HaiNT
 */
public class Display {

    private Validation validation;
    private StudentManager manager;

    /**
     * Constructs a Display object and initializes Validation and Manager.
     */
    public Display() {
        validation = new Validation();
        manager = new StudentManager(validation);
    }

    /**
     * Displays the menu and processes the user's choices.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            int choice = validation.getInt("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    manager.createStudent();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    System.out.println("Exiting program");
                    return;
            }
        }
    }
}
