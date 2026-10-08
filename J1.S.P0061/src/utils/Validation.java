package utils;

import java.util.Scanner;

/**
 * Validation class check input data from keyboard.
 *
 * @version 09/10/2026
 * @author HaiNT
 */
public class Validation {

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
    public double inputPositiveDouble(String message) {

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
}
