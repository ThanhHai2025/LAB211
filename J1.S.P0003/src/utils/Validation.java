package utils;

import java.util.Scanner;

/**
 * Validation class check input data from keyboard.
 *
 * @version 17/09/2026
 * @author HaiNTHE191763
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * The prompt asks a valid integer value entered from the keyboard,
     * repeating until a correct value is entered.
     *
     * @param messageInfor Message asks the user input a valid value.
     * @param messageErrorOutOfRange Error message when value is out of the
     * range.
     * @param messageErrorInvalidNumber Error message when value is not integer
     * number.
     * @param min Minimum value allowed.
     * @param max Maximum value allowed.
     * @return Valid integer value ​​are entered from the keyboard.
     */
    public int getInt(String messageInfor,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {

        //Loop infinitely until user enters a valid value.
        do {
            try {
                System.out.println(messageInfor);
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }
}
