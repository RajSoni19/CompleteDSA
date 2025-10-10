package binary;

import java.util.Arrays;

public class FindPeak2 {

    // Function to find the maximum value in a given column
    public static int findMax(int matrix[][], int n, int m, int col) { 
        int maxvalue = -1; // Initialize maxvalue to -1
        int index = -1; // Initialize index to -1
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] > maxvalue) {
                maxvalue = matrix[i][col]; // Update maxvalue if a larger value is found
                index = i; // Update index to the row of the maxvalue
            }
        }
        return index; // Return the row index of the maximum value in the column
    }

    // Function to find a peak element in the matrix
    public static int[] findpeak(int matrix[][]) {
        int n = matrix.length; // Number of rows in the matrix
        int m = matrix[0].length; // Number of columns in the matrix
        int low = 0, high = m - 1; // Initialize the search range for columns

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the midpoint of the current range
            int maxRowindex = findMax(matrix, n, m, mid); // Find the row index of the maximum value in the mid column
            int left = mid - 1 >= 0 ? matrix[maxRowindex][mid - 1] : -1; // Value to the left of the mid column
            int right = mid + 1 < m ? matrix[maxRowindex][mid + 1] : -1; // Value to the right of the mid column

            // Check if the mid column value is greater than its left and right neighbors
            if (matrix[maxRowindex][mid] > left && matrix[maxRowindex][mid] > right) {
                return new int[]{maxRowindex, mid}; // Return the peak element's position
            } else if (matrix[maxRowindex][mid] < left) {
                high = mid - 1; // If the left neighbor is greater, search in the left half
            } else {
                low = mid + 1; // If the right neighbor is greater, search in the right half
            }
        }
        return new int[]{-1, -1}; // Return -1, -1 if no peak is found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 4, 7, 11, 5},
            {2, 5, 8, 12, 19},
            {0, 6, 9, 1, 22},
            {10, 13, 14, 7, 24},
            {18, 21, 23, 2, 0}
        };
        System.out.println(Arrays.toString(findpeak(matrix))); // Print the peak element's position
    }
}