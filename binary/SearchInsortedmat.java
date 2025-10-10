package binary;
import java.util.*;

public class SearchInsortedmat {

    // Function to search for a target value in a sorted 2D matrix
    public static boolean seachMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size(); // Number of rows
        int m = matrix.get(0).size(); // Number of columns
        int low = 0;
        int high = n * m - 1; // Treat the 2D matrix as a 1D array for binary search

        while (low <= high) {
            int mid = (low + high) / 2; // Middle index in the virtual 1D array
            int row = mid / m, col = mid % m; // Convert 1D index to 2D indices
            if (matrix.get(row).get(col) == target) return true; // Target found
            else if (matrix.get(row).get(col) < target) low = mid + 1; // Search right half
            else high = mid - 1; // Search left half
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

        boolean result = seachMatrix(matrix, 0); // Search for 0 in the matrix
        System.out.println(result); // Output the result (true if found, false otherwise)
    }
}