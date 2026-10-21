package j1.s.p0053;

/**
 * The Sort class contains the Bubble Sort algorithm, both ascending and
 * descending.
 *
 * @version 21/10/2026
 * @author HaiNT
 */
public class Sort {

    /**
     * Sort the array in ascending order using the Bubble Sort algorithm.
     *
     * @param arrayNeedSort The array to be sorted.
     * @return The array has been sorted in ascending order.
     */
    public int[] sortAscending(int[] arrayNeedSort) {

        // Check if the array is empty, return null.
        if (arrayNeedSort == null) {
            return null;
        }
        int temp;

        //Iterate through each sorted array.
        for (int i = 0; i < arrayNeedSort.length - 1; i++) {

            //Push the larger element to the end of the array.
            for (int j = 0; j < arrayNeedSort.length - 1 - i; j++) {

                // Nếu phần tử trước lớn hơn phần tử sau thì tiến hành đổi chỗ
                if (arrayNeedSort[j] > arrayNeedSort[j + 1]) {
                    temp = arrayNeedSort[j];
                    arrayNeedSort[j] = arrayNeedSort[j + 1];
                    arrayNeedSort[j + 1] = temp;
                }
            }
        }
        return arrayNeedSort;
    }

    /**
     * Sort the array in descending order using the Bubble Sort algorithm.
     *
     * @param arrayNeedSort The array to be sorted.
     * @return The array has been sorted in descending order.
     */
    public int[] sortDescending(int[] arrayNeedSort) {

        // Check if the array is empty, return null.
        if (arrayNeedSort == null) {
            return null;
        }

        int temp;

        //Iterate through each sorted array.
        for (int i = 0; i < arrayNeedSort.length - 1; i++) {

            //Push the smaller element to the end of the array.
            for (int j = 0; j < arrayNeedSort.length - 1 - i; j++) {
                if (arrayNeedSort[j] < arrayNeedSort[j + 1]) {
                    temp = arrayNeedSort[j];
                    arrayNeedSort[j] = arrayNeedSort[j + 1];
                    arrayNeedSort[j + 1] = temp;
                }
            }
        }
        return arrayNeedSort;
    }

    /**
     * Function display array
     *
     * @param arr Array to display.
     * @param isAscending True if it's an ascending order, False if it's a
     * descending order.
     */
    public void displayArray(int[] arr, boolean isAscending) {

        //If the array is null, stop and do not print.
        if (arr == null) {
            return;
        }

        //Check to print in ascending or descending format accordingly.
        if (isAscending) {
            System.out.println("----- Ascending -----");

            //Iterate through each element to print with upward arrow formatting.
            for (int i = 0; i < arr.length; i++) {
                System.out.print("[" + arr[i] + "]");
                if (i < arr.length - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        } else {
            System.out.println("----- Descending -----");

            //Iterate through each element to print with a downward arrow formatting.
            for (int i = 0; i < arr.length; i++) {
                System.out.print("[" + arr[i] + "]");
                if (i < arr.length - 1) {
                    System.out.print("<-");
                }
            }
            System.out.println();
        }
    }
}
