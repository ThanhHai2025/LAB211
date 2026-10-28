package matrix_calculation;

/**
 * The MatrixCalculator class handles matrix operations: addition, subtraction,
 * and multiplication.
 */
public class MatrixCalculator {

    /**
     * Perform addition between two matrices.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @param result matrix object used to store the result
     */
    public void additionMatrix(
            Matrix matrix1, Matrix matrix2, Matrix result) {

        int[][] data1 = matrix1.getData();
        int[][] data2 = matrix2.getData();
        int[][] res = result.getData();

        // Calculate the sum of corresponding elements.
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getCols(); j++) {
                res[i][j] = data1[i][j] + data2[i][j];
            }
        }
    }

    /**
     * Perform subtraction between two matrices.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @param result matrix object used to store the result
     */
    public void subtractionMatrix(
            Matrix matrix1, Matrix matrix2, Matrix result) {

        int[][] data1 = matrix1.getData();
        int[][] data2 = matrix2.getData();
        int[][] res = result.getData();

        // Calculate the difference between corresponding elements.
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getCols(); j++) {
                res[i][j] = data1[i][j] - data2[i][j];
            }
        }
    }

    /**
     * Perform multiplication between two matrices.
     *
     * @param matrix1 the first matrix
     * @param matrix2 the second matrix
     * @param result matrix object used to store the result
     */
    public void multiplicationMatrix(
            Matrix matrix1, Matrix matrix2, Matrix result) {

        int[][] data1 = matrix1.getData();
        int[][] data2 = matrix2.getData();
        int[][] res = result.getData();

        // Iterate through each row of Matrix 1.
        for (int i = 0; i < matrix1.getRows(); i++) {

            // Iterate through each column of Matrix 2.
            for (int j = 0; j < matrix2.getCols(); j++) {
                int sum = 0;

                // Calculate the product of the row (Matrix 1) and the column (Matrix 2).
                for (int k = 0; k < matrix1.getCols(); k++) {
                    sum += data1[i][k] * data2[k][j];
                }

                res[i][j] = sum;
            }
        }
    }
}
