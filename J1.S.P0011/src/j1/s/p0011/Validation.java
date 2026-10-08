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
        //Keep asking until the user enters a valid integer within the required range.
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
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

        //Keep asking until the user enters a value that is valid for the selected number base.
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            //Binary can only contain 0 and 1.
            if (base == 2 && value.matches("[01]+")) {
                return value;
            }

            //Decimal can only contain digits from 0 to 9.
            if (base == 10 && value.matches("[0-9]+")) {
                return value;
            }
            //Hexadecimal can contain 0-9 and A-F, Convert the value to uppercase for consistent processing.
            if (base == 16 && value.matches("[0-9A-Fa-f]+")) {
                return value.toUpperCase();
            }
            System.out.println("Error: Invalid value for base " + base + ".");
        }
    }

    /**
     * Ask user whether to continue.
     *
     * @param message input message
     * @return true if user chooses Y
     */
    public boolean getYN(String message) {

        //Keep asking until the user enters either Y or N.
        while (true) {
            System.out.print(message);
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            }
            if (answer.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Error: Please enter Y or N.");
        }
    }
}
