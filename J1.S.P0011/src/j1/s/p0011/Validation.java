package j1.s.p0011;

import java.util.Scanner;

/**
 * Validation class handles user input validation.
 *
 * @version 06/10/2026
 * @author HaiNT
 */
public class Validation {

    private Scanner scanner;

    public Validation() {
        scanner = new Scanner(System.in);
    }

    /**
     * Get an integer in a specific range.
     *
     * @param message input message
     * @param min minimum value
     * @param max maximum value
     * @return valid integer
     */
    public int getInt(
            String message,
            int min,
            int max) {

        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt( scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid integer input! Please enter a number.");
            }
        }
    }

    /**
     * Get a value according to the selected base.
     *
     * @param message input message
     * @param base selected base
     * @return valid input value
     */
    public String getValueByBase(
            String message,
            int base) {

        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();
            if (base == 2 && value.matches("[01]+")) {
                return value;
            }
            if (base == 10 && value.matches("[0-9]+")) {
                return value;
            }
            if (base == 16 && value.matches("[0-9A-Fa-f]+")) {
                return value.toUpperCase();
            }
            System.out.println( "Error: Invalid value for base "+ base + "." );
        }
    }

    /**
     * Ask user whether to continue.
     *
     * @param message input message
     * @return true if user chooses Y
     */
    public boolean getYN(String message) {
        while (true) {
            System.out.print(message);
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            }
            if (answer.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println( "Error: Please enter Y or N."
            );
        }
    }
}
