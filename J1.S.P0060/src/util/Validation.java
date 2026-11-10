package util;

import java.util.Scanner;

/**
 * Validation class handles user input and validates integer values.
 *
 * @version 10/11/2026
 * @author HaiNT
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Reads and validates an integer entered by the user.
     *
     * @param message prompt message for user
     * @param min the minimum allowed value
     * @return a valid integer input
     */
    public int getInt(String message, int min) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine().trim());

                //Step 2: Check whether the number is within the allowed range.
                if (number < min) {
                    System.out.println("Value is invalid.");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please input an integer.");
            }
        }
    }
}
