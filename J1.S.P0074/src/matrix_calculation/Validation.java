package matrix_calculation;

import java.util.Scanner;

/**
 * The Validation class handles user input validation. It ensures that inputs
 * are integers within the required range.
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Input and validate an integer within a specified range.
     *
     * @param mesInfo message displayed before input
     * @param mesErrorOutOfRange message displayed when the number is out of
     * range
     * @param mesErrorInvalidNumber message displayed when input is not an
     * integer
     * @param min minimum allowed value
     * @param max maximum allowed value
     * @return a valid integer
     */
    public int getInt(
            String mesInfo,
            String mesErrorOutOfRange,
            String mesErrorInvalidNumber,
            int min,
            int max) {

        while (true) {
            try {
                System.out.print(mesInfo);
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(mesErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(mesErrorInvalidNumber);
            }
        }
    }

    /**
     * Check whether two matrices have the same dimensions.
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return true if both matrices have the same dimensions
     */
    public boolean isSameSize(Matrix matrix1, Matrix matrix2) {
        return matrix1.getRows() == matrix2.getRows() && matrix1.getCols() == matrix2.getCols();
    }

    /**
     * Check whether two matrices can be multiplied.
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return true if columns of matrix 1 equal rows of matrix 2
     */
    public boolean canMultiply(Matrix matrix1, Matrix matrix2) {
        return matrix1.getCols() == matrix2.getRows();
    }
}
