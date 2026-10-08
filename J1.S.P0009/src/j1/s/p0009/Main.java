package j1.s.p0009;

import java.util.Scanner;

/**
 * Main class run Fibonacci program.
 *
 * @version 30/9/2026
 * @author HaiNTHE191763
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers: ");
        /**
         * count is the number of Fibonacci number user want to display.
         */
        int count = scanner.nextInt();

        //Step 1: Initialize a Fibonacci object.
        Fibonacci fibonacci = new Fibonacci(count);

        //Step 2:  Display the Fibonacci numbers.
        fibonacci.displayFibonacci();
    }
}
