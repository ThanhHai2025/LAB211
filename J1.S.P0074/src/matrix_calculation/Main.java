package matrix_calculation;

/**
 * Main class that controls the flow of the matrix calculator program.
 */
public class Main {

    public static void main(String[] args) {

        // Initialize objects used by the program.
        MatrixCalculator calc = new MatrixCalculator();
        Validation validation = new Validation();

        while (true) {

            // Step 1: Display menu options.
            System.out.println("\n========= MATRIX CALCULATOR =========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Exit");

            // Step 2: Input and validate the user's choice.
            int choice = validation.getInt(
                    "Please choose an option: ",
                    "Error range! Please choose from 1 to 4.",
                    "Invalid! Please enter an integer.",
                    1,
                    4);

            if (choice == 4) {
                System.out.println("Program exited.");
                break;
            }

            // Step 3: Display the selected operation.
            switch (choice) {
                case 1:
                    System.out.println("----- Addition -----");
                    break;
                case 2:
                    System.out.println("----- Subtraction -----");
                    break;
                case 3:
                    System.out.println("----- Multiplication -----");
                    break;
                default:
                    break;
            }

            // Step 4: Input dimensions of Matrix 1.
            int row1 = validation.getInt(
                    "Enter Rows Matrix 1: ",
                    "Rows must be greater than 0.",
                    "Invalid! Please enter an integer.",
                    1,
                    Integer.MAX_VALUE);

            int col1 = validation.getInt(
                    "Enter Columns Matrix 1: ",
                    "Columns must be greater than 0.",
                    "Invalid! Please enter an integer.",
                    1,
                    Integer.MAX_VALUE);

            // Step 5: Create Matrix 1 and input its elements.
            Matrix matrix1 = new Matrix(row1, col1);

            System.out.println("Enter elements of Matrix 1:");
            matrix1.inputMatrix(validation);

            // Step 6: Input dimensions of Matrix 2 and validate compatibility.
            int row2;
            int col2;
            Matrix matrix2;

            while (true) {
                row2 = validation.getInt(
                        "Enter Rows Matrix 2: ",
                        "Rows must be greater than 0.",
                        "Invalid! Please enter an integer.",
                        1,
                        Integer.MAX_VALUE);

                col2 = validation.getInt(
                        "Enter Columns Matrix 2: ",
                        "Columns must be greater than 0.",
                        "Invalid! Please enter an integer.",
                        1,
                        Integer.MAX_VALUE);

                matrix2 = new Matrix(row2, col2);

                if ((choice == 1 || choice == 2)
                        && !validation.isSameSize(matrix1, matrix2)) {

                    System.out.println(
                            "Matrix 2 must have the same size as Matrix 1.");

                } else if (choice == 3
                        && !validation.canMultiply(matrix1, matrix2)) {

                    System.out.println(
                            "Number of columns in Matrix 1 must equal "
                            + "number of rows in Matrix 2.");

                } else {
                    break;
                }
            }

            // Step 7: Input elements of Matrix 2.
            System.out.println("Enter elements of Matrix 2:");
            matrix2.inputMatrix(validation);

            // Step 8: Display input matrices.
            System.out.println("\n========= RESULT =========");

            Matrix result;

            switch (choice) {

                // Perform addition.
                case 1:
                    result = new Matrix(row1, col1);

                    matrix1.display();
                    System.out.println("+");
                    matrix2.display();
                    System.out.println("=");

                    calc.additionMatrix(matrix1, matrix2, result);
                    result.display();
                    break;

                // Perform subtraction.
                case 2:
                    result = new Matrix(row1, col1);

                    matrix1.display();
                    System.out.println("-");
                    matrix2.display();
                    System.out.println("=");

                    calc.subtractionMatrix(matrix1, matrix2, result);
                    result.display();
                    break;

                // Perform multiplication.
                case 3:
                    result = new Matrix(row1, col2);

                    matrix1.display();
                    System.out.println("*");
                    matrix2.display();
                    System.out.println("=");

                    calc.multiplicationMatrix(matrix1, matrix2, result);
                    result.display();
                    break;

                default:
                    break;
            }
        }
    }
}
