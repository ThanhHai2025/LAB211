package model;

import java.util.Random;

/**
 * InsertionSort class provides initialization, generates random array, displays
 * and sorts array by Selection Sort algorithm.
 *
 * @version 17/09/2026
 * @author HaiNTHE191763
 */
public class InsertionSort {

    /**
     * Element attribute to store ArrayObj to integer.
     */
    private int[] array;

    /**
     * Initialize the array with the specified size.
     *
     * @param size size of array
     */
    public InsertionSort(int size) {
        array = new int[size];
    }

    /**
     * Generate array with random element.
     */
    public void generateArray() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(array.length);
        }
    }

    /**
     * Display array on screen.
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Sort array using Insertion Sort algorithm.
     */
    public void insertionSort() {

        // Loop through each position starting from the second element.
        for (int i = 1; i < array.length; i++) {

            // Store the current element to insert.
            int key = array[i];

            // Start comparing from the element before key.
            int j = i - 1;

            // Shift larger elements to the right.
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // Insert key into the correct position.
            array[j + 1] = key;
        }
    }
}
