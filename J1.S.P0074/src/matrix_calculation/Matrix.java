package matrix_calculation;

/**
 * The Matrix class is a mathematical matrix and provides operations to add,
 * subtract, and multiply matrices.
 *
 * @author HaiNT
 */
public class Matrix {

    private int rows;
    private int cols;
    private int[][] data;

    /**
     * Constructor to initialize a matrix with given size.
     *
     * @param rows Number of rows in the matrix.
     * @param cols Number of columns in the matrix.
     * @param data the matrix data
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new int[rows][cols];
    }

    /**
     * Get the number of rows.
     *
     * @return Number of rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Get the number of columns.
     *
     * @return Number of columns.
     */
    public int getCols() {
        return cols;
    }

    /**
     * Get the matrix data.
     *
     * @return 2D array matrix data.
     */
    public int[][] getData() {
        return data;
    }

    /**
     * Input elements into the matrix.
     *
     * @param validation object used to validate user input
     */
    public void inputMatrix(Validation validation) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = validation.getInt(
                        "Enter Matrix[" + (i + 1) + "][" + (j + 1) + "]: ",
                        "Error range!",
                        "Invalid! Please enter an integer.",
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE);
            }
        }
    }

    /**
     * Display the matrix.
     */
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + data[i][j] + "]");
            }
            System.out.println();
        }
    }
}
