package j1.s.p0009;

/**
 * The Fibonacci class generates and displays the first 45 Fibonacci numbers
 * using recursion method.
 *
 * @version 30/09/2026
 * @author HaiNTHE191763
 */
public class Fibonacci {

    /**
     * Declare the limit of Fibonacci sequence
     */
    private final int limit = 45;

    /**
     * Recursively calculates the Fibonacci number at position n.
     *
     * @param n the position of the Fibonacci number
     * @return the Fibonacci number at position n
     */
    public long getFibonacci(int n) {

        // Base cases of the Fibonacci sequence.
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //Recursively calculate F(n) = F(n - 1) + F(n - 2).
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    /**
     * Displays the first 45 Fibonacci numbers on screen.
     */
    public void displayFibonacci() {
        System.out.println("The 45 sequence fibonacci: ");

        // Loop to run from index 0 to limit - 1 to print each Fibonacci number.
        for (int i = 0; i < limit; i++) {
            System.out.print(getFibonacci(i));

            //Print commas and spaces for all numbers in array except the last one.
            if (i < limit - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
