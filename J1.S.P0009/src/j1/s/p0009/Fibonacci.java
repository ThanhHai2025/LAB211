package j1.s.p0009;

/**
 * The Fibonacci class processing logic and display Fibonacci on screen.
 *
 * @version 30/09/2026
 * @author HaiNTHE191763
 */
public class Fibonacci {

    // Array to store calculated Fibonacci numbers and avoid recalculation.
    private long[] fiboCache;

    /**
     * Constructs a Fibonacci object and initializes the cache for 45 Fibonacci
     * numbers.
     */
    public Fibonacci() {
        fiboCache = new long[45];
    }

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

        // Return the previously calculated value if available.
        if (fiboCache[n] != 0) {
            return fiboCache[n];
        }

        //Recursively calculate F(n) = F(n - 1) + F(n - 2).
        fiboCache[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return fiboCache[n];
    }

    /**
     * Displays the first count Fibonacci numbers.
     *
     * @param count the number of Fibonacci numbers to display.
     */
    public void displayFibonacci(int count) {
        System.out.println("The " + count + " sequence fibonacci: ");

        // Loop to run from index 0 to count - 1 to print each Fibonacci number.
        for (int i = 0; i < count; i++) {
            System.out.print(getFibonacci(i));

            //Print commas and spaces for all numbers in array except the last one.
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
