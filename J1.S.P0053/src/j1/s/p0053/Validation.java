package j1.s.p0053;

import java.util.Scanner;

/**
 * The Validation layer is used to check user input data.
 *
 * @version 21/10/2026
 * @author HaiNT
 */
public class Validation {

    //Initialize a Scanner object to read data from the keyboard
    private Scanner scanner = new Scanner(System.in);

    /**
     * Check if the input string is a valid integer.
     *
     * @param inputValue The value chain needs to be examined.
     * @return Returns an integer if valid, otherwise returns null.
     */
    public Integer checkIn(String inputValue) {
        try {
            int number = Integer.parseInt(inputValue.trim());
            return number;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * The user is asked to enter a positive integer.
     *
     * @param msg Notification of import instructions.
     * @return Valid positive integers.
     */
    public int getPositiveInt(String msg) {

        //Loop that requires re-entry until the condition is met.
        while (true) {
            System.out.print(msg);
            String input = scanner.nextLine();
            Integer number = checkIn(input);

            //Check if the input data is not an integer.
            if (number == null) {
                System.out.println("Please input number and number is greater than zero");
                continue;
            }

            // Check if the input number is less than or equal to 0.
            if (number <= 0) {
                System.out.println("Please input number and number is greater than zero");
                continue;
            }
            return number;
        }
    }

    /**
     * The user is asked to enter any integer.
     *
     * @param msg Notification of import instructions.
     * @return Valid integer.
     */
    public int getInt(String msg) {

        //Loop to force re-entry until the integer is correctly formatted
        while (true) {
            System.out.print(msg);
            String input = scanner.nextLine();
            Integer number = checkIn(input);

            //Check if the data is not an integer
            if (number == null) {
                System.out.println("Please input a valid integer number!");
                continue;
            }
            return number;
        }
    }
}
