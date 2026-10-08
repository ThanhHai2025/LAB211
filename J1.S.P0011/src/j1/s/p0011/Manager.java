package j1.s.p0011;

/**
 * Manager class handles base conversion.
 *
 * @version 06/10/2026
 * @author HaiNT
 */
public class Manager {

    /**
     * The base of the input value.
     */
    private int fromBase;

    /**
     * The base of the output value.
     */
    private int toBase;

    /**
     * The value entered by the user.
     */
    private String inputValue;

    /**
     * Convert menu choice to actual base.
     *
     * @param choice menu choice
     * @return actual base
     */
    public int choiceToBase(int choice) {
        if (choice == 1) {
            return 2;
        }
        if (choice == 2) {
            return 10;
        }
        return 16;
    }

    /**
     * Set input base.
     *
     * @param fromBase input base
     */
    public void setFromBase(int fromBase) {
        this.fromBase = fromBase;
    }

    /**
     * Set output base.
     *
     * @param toBase output base
     */
    public void setToBase(int toBase) {
        this.toBase = toBase;
    }

    /**
     * Set input value.
     *
     * @param inputValue value entered by user
     */
    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    /**
     * Get input base.
     *
     * @return input base
     */
    public int getFromBase() {
        return fromBase;
    }

    /**
     * Convert input value to output base.
     *
     * @return converted value
     */
    public String convert() {

        // Step 1: Convert the input value to decimal
        int decimalValue = convertToDecimal();

        // Step 2: Convert the decimal value to the selected output base
        return convertFromDecimal(decimalValue);
    }

    /**
     * Convert input value from its base to decimal.
     *
     * @return decimal value
     */
    private int convertToDecimal() {
        int decimalValue = 0;

        //String containing all possible digits for base 2, 10 and 16.
        String digits = "0123456789ABCDEF";
        //Convert hexadecimal letters to uppercase so that A-F
        String valueUpper = inputValue.toUpperCase();

        //Loop through each character from left to right.
        for (int i = 0; i < valueUpper.length(); i++) {

            //Get the current character from the input value.
            char character = valueUpper.charAt(i);

            //Convert the character into its numeric value. EX: 'A' -> 10.
            int digit = digits.indexOf(character);

            //Add the current digit to the decimal value according to the selected input base.
            decimalValue = decimalValue * fromBase + digit;
        }
        return decimalValue;
    }

    /**
     * Convert decimal value to output base.
     *
     * @param decimalValue decimal value
     * @return converted value
     */
    private String convertFromDecimal(int decimalValue) {

        //Case: decimal 0 is simply "0".
        if (decimalValue == 0) {
            return "0";
        }

        //String containing all possible digits for base 2, 10 and 16.
        String digits = "0123456789ABCDEF";
        String result = "";

        //Repeatedly divide the decimal value by the output base.
        while (decimalValue > 0) {

            //Get the remainder to determine the current digit.
            int remainder = decimalValue % toBase;

            //Add the new digit to the beginning of the result
            result = digits.charAt(remainder) + result;

            //Get the quotient to continue the next division.
            decimalValue = decimalValue / toBase;
        }
        return result;
    }

    /**
     * Display base menu.
     *
     * @param title menu title
     */
    public void displayBaseMenu(String title) {
        System.out.println("---------------- " + title + " ----------------");
        System.out.println("1. Binary (Base 2)");
        System.out.println("2. Decimal (Base 10)");
        System.out.println("3. Hexadecimal (Base 16)");
    }
}
