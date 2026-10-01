package main;

import entity.LinearSearch;
import utils.Validation;

/**
 * Main class is used to run LinearSearch program.
 *
 * @version 11/09/2026
 * @author HaiNTHE191763
 */
public class Main {

    public static void main(String[] args) {
        Validation validator = new Validation();

        //Step 1: Input the number of elements in the array.
        int number = validator.getInt(
                "Enter number of array: ",
                "Number must be > 0",
                "Invalid!",
                1,
                Integer.MAX_VALUE
        );
        try {

            //Step 2: Initialize the array
            LinearSearch linearSearch = new LinearSearch(number);

            //Step 3: Generate array with random numbers.
            linearSearch.generateArray();

            //Step 4: Enter the value to search for in the array from the keyboard.
            int key = validator.getInt(
                    "Enter search value: ",
                    "Error range!",
                    "Invalid!",
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
            );

            // Step 5: Display array on screen.
            System.out.print("The array: ");
            linearSearch.display();

            //Step 6: Perform Linear Search. 
            int index = linearSearch.linearSearch(key);

            //Step 7: Display the index of search number in array.   
            if (index == -1) {

                //The index returns -1 if the array does not contain the value being searched for.
                System.out.println("Can not found -1");
            } else {
                //If found, print the first index containing that value.
                System.out.println("Found " + key + " at index: " + index);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
