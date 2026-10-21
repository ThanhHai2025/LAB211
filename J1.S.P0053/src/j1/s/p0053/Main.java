package j1.s.p0053;

import java.util.Scanner;

/**
 * The Main class controls the main execution flow of the Bubble Sort program.
 *
 * @version 21/10/2026
 * @author HaiNT
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        Sort sortObj = new Sort();

        int[] array = null;

        while (true) {

            //Display the program menu
            System.out.println("========= Bubble Sort program =========");
            System.out.println("1. Input Element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Descending");
            System.out.println("4. Exit");

            //User select function option 
            int choice = validation.getInt("Please choice one option: ");

            switch (choice) {
                case 1:
                    //Step 1: Enter the length and elements for the array.
                    System.out.println("----- Input Element -----");
                    System.out.println("Input Length Of Array");
                    int length = validation.getPositiveInt("Enter Number: ");

                    array = new int[length];
                    //Step 2: Loop to input the value of each element of the array
                    for (int i = 0; i < length; i++) {
                        array[i] = validation.getInt("Enter Number " + (i + 1) + ": ");
                    }
                    break;

                case 2:
                    //Check if the array has already been entered with data
                    if (array == null) {
                        System.out.println("Please input the array first (Option 1)!");
                        break;
                    }
                    //Step 3: Sort the array in ascending order.
                    int[] sortedAsc = sortObj.sortAscending(array);

                    //Step 4: Display the array results after sorting in ascending order.
                    sortObj.displayArray(sortedAsc, true);
                    break;

                case 3:
                    //Check if the array has already been entered with data.
                    if (array == null) {
                        System.out.println("Please input the array first (Option 1)!");
                        break;
                    }

                    //Step 3: Sort the array in descending order.
                    int[] sortedDesc = sortObj.sortDescending(array);

                    //Step 4: Display the array results after sorting in descending order.
                    sortObj.displayArray(sortedDesc, false);
                    break;

                case 4:
                    //Step 5: Exit the program.
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose between 1 and 4.");
            }
            System.out.println();
        }
    }
}
