package j1.s.p0009;

/**
 * Main class run Fibonacci program.
 *
 * @version 30/9/2026
 * @author HaiNTHE191763
 */
public class Main {
    public static void main(String[] args) {
        // Number of Fibonacci numbers to display.
        int count = 45;
        
        //Step 1: Create a Fibonacci object.
        Fibonacci fibonacci = new Fibonacci();
        
        //Step 2:  Display the first 45 Fibonacci numbers.
        fibonacci.displayFibonacci(count);
    }
}
