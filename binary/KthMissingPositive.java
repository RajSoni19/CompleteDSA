package binary;

public class KthMissingPositive {

    // Function to find the k-th missing positive number in a sorted array
    public static int missing(int vec[], int k, int n) {
        int low = 0;
        int high = n - 1;
        // Binary search to find the position where k-th missing number fits
        while (low <= high) {
            int mid = (low + high) / 2;
            // Calculate how many numbers are missing up to index mid
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1; // Move right if less than k numbers are missing
            } else {
                high = mid - 1; // Move left if at least k numbers are missing
            }
        }
        // The answer is low + k (low is the number of elements before the k-th missing)
        return low + k;
    }

    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10}; // Input sorted array
        int n = 4, k = 4; // Array size and k-th missing to find
        System.out.println(missing(vec, k, n)); // Output the result
    }
}