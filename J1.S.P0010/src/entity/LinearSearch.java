package entity;

import java.util.Random;

/**
 * LinearSearch class is used to create an array of integers, generate random
 * values, display the array, and perform a linear search for a value within the
 * array.
 *
 * @version 29/09/2026
 * @author HaiNTHE191763
 */
public class LinearSearch {

    /**
     * Element attribute to store ArrayObj to integer.
     */
    private int[] array;

    /**
     * Initialize the array with the specified size.
     *
     * @param size size of array
     */
    public LinearSearch(int size) {
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
     * Search the value in array using Linear Search.
     *
     * @param key the value to search for.
     * @return the index of first occurrence, or -1 if not found.
     */
    public int linearSearch(int key) {

        //Loop through each element in the array.
        for (int i = 0; i < array.length; i++) {
            //Return the index if the value is found.
            if (array[i] == key) {
                return i;
            }
        }
        //Return -1 if the value is not found.
        return -1;
    }
}
