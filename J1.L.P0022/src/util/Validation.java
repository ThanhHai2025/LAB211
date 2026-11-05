package util;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Utility class to validate and read candidate input data from console.
 *
 * @version 02/11/2026
 * @author HaiNT
 */
public class Validation {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Regular expression for valid email format (<account name>@<domain>).
     */
    private final String EMAIL_REGEX = "^[A-za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    /**
     * Regular expression for valid phone number (digits only, minimum 10
     * digits).
     */
    private final String PHONE_REGEX = "^\\d{10,}$";

    /**
     * Get an integer input within a specific range [min, max].
     *
     * @param mesage Prompt message display to user
     * @param min Minimum acceptable value
     * @param max Maximum acceptable value
     * @return Valid integer value within range
     */
    public int getInt(String mesage, int min, int max) {

        //Loop continuously until a valid integer value within range is entered.
        while (true) {
            System.out.print(mesage);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());

                //Check if value is inside valid range [min, max].
                if (value >= min && value <= max) {
                    return value;
                }
                System.err.println("Please input number in range [" + min + ", " + max + "]");
            } catch (NumberFormatException e) {
                System.err.println("Invalid! Please input integer number!");
            }
        }
    }

    /**
     * Get a non-empty string input.
     *
     * @param message Prompt message display to user
     * @return Non-empty input string
     */
    public String getString(String message) {

        //Loop continuously until user input a non-empty string.
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            //Check if string is not empty.
            if (!input.isEmpty()) {
                return input;
            }
            System.err.println("Input can not be empty. Please enter again.");
        }
    }

    /**
     * Check birth date: 4-digits year from 1900 to current year.
     *
     * @param message Prompt message display to user
     * @return valid birth year
     */
    public int getBirthDate(String message) {

        //Get the system's current year dynamically
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        //Loop continuously until a valid birth year is entered.
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.matches("\\d{4}")) {
                System.err.println("Birth date must be a 4-digits number!");
                continue;
            }
            int year = Integer.parseInt(input);

            //Check if birth year is between 1900 and current year.
            if (year >= 1900 && year <= currentYear) {
                return year;
            }
            System.err.println("Birth date must be from 1900 to current year (" + currentYear + ")");
        }
    }

    /**
     * Check phone: digits only, minimum 10 digits.
     *
     * @param message Prompt message display to user
     * @return valid phone number string
     */
    public String getPhone(String message) {

        //Loop continuously until phone format matches regex.
        while (true) {
            System.out.print(message);
            String phone = scanner.nextLine().trim();

            //Check if phone number matches regex.
            if (phone.matches(PHONE_REGEX)) {
                return phone;
            }
            System.err.println("Phone must be number and minimum 10 digits!");
        }
    }

    /**
     * Check Email format: {<account name>@<domain>}.
     *
     * @param message Prompt message display to user
     * @return Valid email string
     */
    public String getEmail(String message) {

        //Loop continuously until email format matches regex.
        while (true) {
            System.out.print(message);
            String email = scanner.nextLine().trim();

            //Check if email matches regex.
            if (email.matches(EMAIL_REGEX)) {
                return email;
            }
            System.err.println("Email must be in format <account name>@<domain> (e.g: annguyen@fpt.edu.vn)!");
        }
    }

    /**
     * Check year of experience: integer from 0 to 100.
     *
     * @param message Prompt message display to user
     * @return valid year of experience
     */
    public int getYearOfExp(String message) {
        //Reuse getInt method to check range 0 to 100
        return getInt(message, 0, 100);
    }

    /**
     * Check rank of graduation: excellence, good, fair, poor.
     *
     * @param message Prompt message display to user
     * @return standardized graduation rank string
     */
    public String getGraduationRank(String message) {

        //Loop continuously until input match one of 4 valid ranks.
        while (true) {
            System.out.print(message);
            String rank = scanner.nextLine().trim();

            //Check case-insensitive matche for 4 allowed ranks.
            if (rank.equalsIgnoreCase("Excellence")
                    || rank.equalsIgnoreCase("Good")
                    || rank.equalsIgnoreCase("Fair")
                    || rank.equalsIgnoreCase("Poor")) {

                //Capitalize first letter and lowercase remaining letters.
                return rank.substring(0, 1).toUpperCase() + rank.substring(1).toLowerCase();
            }
            System.err.println("Rank of graduation must be one of: Excellence, Good, Fair, Poor!");
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
}
