package main;

import model.BubbleSort;
import utils.Validation;

/**
 * Main class is used to run Bubble Sort program.
 *
 * @version 11/09/2026
 * @author HaiNTHE191763
 */
public class Main {

    public static void main(String[] args) {
        Validation validator = new Validation();

        //Step 1: Input the number of elements in the array.
        int size = validator.getInt("Enetr number of array: ",
                "Error: Number must be grater than 0!",
                "Error: Invalid integer number. Please enter again: ",
                1, Integer.MAX_VALUE);

        //Step 2: Initialize the array and generate random numbers.
        BubbleSort bubbleSortObj = new BubbleSort(size);
        bubbleSortObj.generateArray();

        //Step 3: Display the array before sorting.
        System.out.println("Unsorted array: ");
        bubbleSortObj.display();

        //Step 4: Sort the array using the Bubble Sort algorithm.
        bubbleSortObj.bubbleSort();

        //Step 5: Display the array after sorting.
        System.out.println("Sorted array: ");
        bubbleSortObj.display();
    }
}
