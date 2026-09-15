package utils;

import java.util.Scanner;

/**
 * Validation class check input data from keyboard.
 *
 * @version 11/09/2026
 * @author HaiNTHE191763
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    public int getInt(String messageInfor, String messageErrorOutOfRange,
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
