package util;

import java.util.Scanner;

/**
 * Validation class to validate and read candidate input data from console.
 *
 * @version 17/11/206
 * @author HaiNT
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Get an integer input within a specific range [min, max].
     *
     * @param message Prompt message display to user
     * @param min Minimum acceptable value
     * @param max Maximum acceptable value
     * @return Valid integer value within range
     */
    public int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }
                System.err.println("Please input number in range[ " + min + " ," + max + " ].");
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer! Please enter again.");
            }
        }
    }

    /**
     * Checks whether the input string is not empty.
     *
     * @param message Prompt message display to user
     * @return valid string
     */
    public String getString(String message) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.out.println("Not empty. Enter again: ");
        }
    }

    /**
     * Ask user whether to continue (Y/N).
     *
     * @param message Prompt message display to user
     * @return true if user choose 'Y', false if 'N'.
     */
    public boolean getYN(String message) {
        //Loop continuously until user inputs Y or N.
        while (true) {
            System.out.print(message);
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            }
            if (answer.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y or N!");
        }
    }

    /**
     * Ask user whether to input (U/D).
     *
     * @param message Prompt message display to user
     * @return true if user choose 'U', false if 'D'.
     */
    public boolean getUD(String message) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine().trim();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.out.println("Only onput U or D! Please enter again.");
        }
    }

    /**
     * Checks whether the course name is valid.
     *
     * @param message Prompt message display to user
     * @return valid course name
     */
    public String getCourse(String message) {
        while (true) {
            System.out.print(message);
            String result = scanner.nextLine().trim();
            if (result.equalsIgnoreCase("Java")) {
                return "Java";
            }
            if (result.equalsIgnoreCase(".Net")) {
                return ".Net";
            }
            if (result.equalsIgnoreCase("C/C++")) {
                return "C/C++";
            }
            System.err.println("Course must be Java, .Net or C/C++");
        }
    }
}
