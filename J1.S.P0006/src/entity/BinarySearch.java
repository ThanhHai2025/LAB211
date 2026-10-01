package entity;

import java.util.Random;

/**
 * The BinarySearch class is used to create an array of integers, generate
 * random values, sort the array in ascending order, display the array, and
 * perform a binary search for a value in the array.
 *
 * @version 30/09/2026
 * @author HaiNTHE191763
 */
public class BinarySearch {

    /**
     * Element attribute to store ArrayObj to integer.
     */
    private int[] array;

    /**
     * Initialize the array with the specified size.
     *
     * @param size size of array
     */
    public BinarySearch(int size) {
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
     * Sort the array in ascending order.
     */
    public void sort() {

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

    /**
     * Search the value in the sorted array using Binary Search.
     *
     * @param key the value to search for.
     * @return the index of key, or -1 if not found.
     */
    public int binarySearch(int key) {

        //Set the left and right boundaries of the search range.
        int left = 0;
        int right = array.length - 1;

        //Repeat the search process until the key
        while (left <= right) {

            //Calculate the center position of the current search range.
            int mid = (left + right) / 2;

            //If the middle value is smaller than key, ignore the left half.
            if (array[mid] < key) {
                left = mid + 1;

                //If the middle value is greater than key, ignore the right half.
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {

                // If the middle value matches key, return that position.
                return mid;
            }
        }
        //Return -1 when the key is not found.
        return -1;
    }
}
