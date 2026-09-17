package main;

import model.InsertionSort;
import utils.Validation;

/**
 * Main class is used to run Insertion Sort program.
 *
 * @version 17/09/2026
 * @author HaiNTHE191763
 */
public class Main {

    public static void main(String[] args) {
        Validation validator = new Validation();

        //Step 1: Input the number of elements in the array.
        int size = validator.getInt("Enter number of array: ",
                "Error: Number must be greater than 0.",
                "Error: Invalid integer number.",
                1, Integer.MAX_VALUE);

        //Step 2: Initialize the array and generate random numbers.
        InsertionSort insertionSortObj = new InsertionSort(size);
        insertionSortObj.generateArray();

        //Step 3: Display the array before sorting.
        System.out.print("Unsorted array: ");
        insertionSortObj.display();

        //Step 4: Sort the array using the Selection Sort algorithm.
        insertionSortObj.insertionSort();

        //Step 5: Display the array after sorting.
        System.out.print("Sorted array: ");
        insertionSortObj.display();
    }
}
