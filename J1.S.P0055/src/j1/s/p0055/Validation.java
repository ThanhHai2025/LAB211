package j1.s.p0055;

import java.util.Scanner;

/**
 * Validation class check input data from keyboard.
 *
 * @version 29/10/2026
 * @author HaiNT
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * return the valid integer value scanned from the input
     *
     * @param messageInfo: to printed integer number from user
     * @param messageErrorOutOfRange: to printed error out of range if it is
     * exceed value range
     * @param messageErrorInvalidNumber: to printed error if it's not number as
     * letter, string,...
     * @param min: minimum limit value
     * @param max: maximum limit value
     * @return the valid integer value scanned from the input
     */
    public int getInt(String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {

        // Loop continuously until a valid integer is entered
        do {
            try {
                // Prompt user and parse input to integer
                System.out.print(messageInfo);
                int number = Integer.parseInt(scanner.nextLine());

                // Check if number is within the allowed range [min, max]
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                // Catch error if input is not a valid number
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
     * Return the valid integer value, or the default value if the input is
     * empty.
     *
     * @param messageInfo: to printed message ask user to input
     * @param messageErrorOutOfRange: to printed error if it is out of range
     * @param messageErrorInvalidNumber: to printed error if it's not a number
     * @param min: minimum limit value
     * @param max: maximum limit value
     * @param defaultValue: value returned when the user just presses Enter
     * @return the valid integer value, or defaultValue if input is empty
     */
    public int getOptionalInt(String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max, int defaultValue) {

        // Loop continuously until valid input or empty is entered
        do {
            System.out.print(messageInfo);
            String input = scanner.nextLine().trim();

            // Check if input is empty, return the default value
            if (input.isEmpty()) {
                return defaultValue;
            }
            try {
                // Parse input string to integer
                int number = Integer.parseInt(input);

                // Check if number is within the allowed range [min, max]
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
     * Return valid the String.
     *
     * @param messageInfo to printed integer number from user
     * @param messageError to printed String is the error
     * @param REGEX the format string is correct.
     * @return the string values from user.
     */
    public String getString(String messageInfo,
            String messageError, final String REGEX) {

        // Loop continuously until a valid string matching the regex is entered
        do {
            System.out.print(messageInfo);
            String str = scanner.nextLine();

            // Check if input string matches the regex format
            if (str.matches(REGEX)) {
                return str;
            }

            // Print error message if format is incorrect
            System.out.println(messageError);
        } while (true);
    }
}
