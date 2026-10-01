package main;

import entity.BinarySearch;
import utils.Validation;

/**
 * Main class is used to run BinarySearch program.
 *
 * @version 30/09/2026
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
            BinarySearch binarySearch = new BinarySearch(number);

            //Step 3: Generate array with random numbers.
            binarySearch.generateArray();

            //Step 4: Enter the value to search for in the array from the keyboard.
            int key = validator.getInt(
                    "Enter search value: ",
                    "Error range!",
                    "Invalid!",
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
            );

            // Step 5: Display sorterd array on screen.
            System.out.print("Sorted array: ");
            binarySearch.sort();
            binarySearch.display();

            //Step 6: Perform Binary Search. 
            int index = binarySearch.binarySearch(key);

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
