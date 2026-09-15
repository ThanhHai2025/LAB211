package model;

import java.util.Random;

/**
 * SelectionSort class provides initialization, generates random array, displays
 * and sorts array bay Selection Sort algorithm.
 *
 * @version 15/09/2026
 * @author HaiNTHE191763
 */
public class SelectionSort {

    private int[] array;

    /**
     * Initialize the array with the specified size.
     *
     * @param size size of array
     */
    public SelectionSort(int size) {
        array = new int[size];
    }

    /**
     * Generate random array.
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
     * Sort array using Selection Sort algorithm.
     */
    public void selectionSort() {
        int minIndex;

        // Duyệt từng vị trí trong mảng.
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            //Duyệt tìm phần tủ nhỏ nhất trong mảng chưa sắp xếp.
            for (int j = i + 1; j < array.length; j++) {
                //Find curently smaller element and update the position of this element
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
