package model;

import java.util.Random;

/**
 * BubbleSort class provides initialization, generates random array, displays
 * and sorts array by Bubble Sort algorithm.
 *
 * @version 11/09/2026
 * @author HaiNTHE191763
 */
public class BubbleSort {

    /**
     * Element attribute to store ArrayObj to integer.
     */
    private int[] array;

    /**
     * Initialize the array with the specified size.
     *
     * @param size size of array
     */
    public BubbleSort(int size) {
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
     * Sort array using Bubble Sort algorithm.
     */
    public void bubbleSort() {

        //Loop through each sorting pass
        for (int i = 0; i < array.length; i++) {

            //Push the largest elements to the end of the unsorted array.
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
