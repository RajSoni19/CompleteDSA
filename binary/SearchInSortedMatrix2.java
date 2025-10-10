package binary;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInSortedMatrix2 {

    // Function to search for a target value in a sorted 2D matrix
    // The matrix is sorted such that each row and each column is in ascending order
    public static boolean searchElement(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size(); // Number of rows
        int m = matrix.get(0).size(); // Number of columns
        int row = 0, col = m - 1; // Start from the top-right corner col=15(here)

        // Loop until we go out of bounds
        while (row < n && col >= 0) {
            if (matrix.get(row).get(col) == target) 
                return true; // Target found
            else if (matrix.get(row).get(col) < target) 
                row++; // Move down if current element is less than target
            else 
                col--; // Move left if current element is greater than target
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11, 15)));
        matrix.add(new ArrayList<>(Arrays.asList(2, 5, 8, 12, 19)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9, 16, 22)));
        matrix.add(new ArrayList<>(Arrays.asList(10, 13, 14, 17, 24)));
        matrix.add(new ArrayList<>(Arrays.asList(18, 21, 23, 26, 30)));
        boolean result = searchElement(matrix, 9); // Search for 9 in the matrix
        System.out.println(result); // Output the result (true if found, false otherwise)
    }
}