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

        // Step 1: Convert input to decimal
        int decimalValue = convertToDecimal();

        // Step 2: Convert decimal to output base
        return convertFromDecimal(decimalValue);
    }

    /**
     * Convert input value from its base to decimal.
     *
     * @return decimal value
     */
    private int convertToDecimal() {
        int decimalValue = 0;
        String digits = "0123456789ABCDEF";
        String valueUpper = inputValue.toUpperCase();
        for (int i = 0; i < valueUpper.length(); i++) {
            char character = valueUpper.charAt(i);
            int digit = digits.indexOf(character);
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
        if (decimalValue == 0) {
            return "0";
        }
        String digits = "0123456789ABCDEF";
        String result = "";
        while (decimalValue > 0) {
            int remainder = decimalValue % toBase;
            result = digits.charAt(remainder) + result;
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
