package j1.s.p0009;

/**
 * The Fibonacci class generates and displays the first 45 Fibonacci numbers
 * using recursion method.
 *
 * @version 30/09/2026
 * @author HaiNT
 */
public class Fibonacci {

    // Store the number of Fibonacci numbers to display. 
    private int count;

    /**
     * Initialize the number of Fibonacci numbers.
     *
     * @param count the number of Fibonacci numbers.
     */
    public Fibonacci(int count) {
        this.count = count;
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
        //Recursively calculate F(n) = F(n - 1) + F(n - 2).
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    /**
     * Displays the first 45 Fibonacci numbers on screen.
     */
    public void displayFibonacci() {
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
