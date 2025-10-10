package Arrays;

public class SetMatrixZero {

    // Function to set entire row and column to zero if an element is zero
    public static void Matrixzero(int matrix[][], int n, int m) {
        int col0 = 1; // Flag to check if first column needs to be zeroed

        // Step 1: Mark rows and columns that need to be zeroed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the row
                    if (j != 0) {
                        matrix[0][j] = 0; // Mark the column
                    } else {
                        col0 = 0; // First column needs to be zeroed
                    }
                }
            }
        }

        

        // Step 2: Set matrix cells to zero based on marks (excluding first row and column)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Zero out the first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Zero out the first column if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // Print the final matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int n = matrix.length;
        int m = matrix[0].length;
        Matrixzero(matrix, n, m);
    }
}