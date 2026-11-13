package j1.s.p0056;

import java.util.Scanner;

/**
 *
 * Validation class to validate and read candidate input data from console.
 *
 * @version 05/11/2026
 * @author HaiNT
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Enter an integer number and validate the input.
     *
     * @param message prompt message for the user
     * @param min: minimum limit value
     * @param max: maximum limit value
     * @param messageOutOfRange the message displayed if the input is outside
     * the valid range
     * @return a valid integer input
     */
    public int getInt(String message, int min, int max, String messageOutOfRange) {
        while (true) {
            try {
                // Prompt user and parse input to integer
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine());

                // Check if number is within the allowed range [min, max]
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println(messageOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer! Please enter again.");
            }
        }
    }

    /**
     * Enter a non-empty string and validate the input.
     *
     * @param message prompt message for the user
     * @return a valid non-empty string input
     */
    public String getString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty! Please enter again. ");
        }
    }
}
