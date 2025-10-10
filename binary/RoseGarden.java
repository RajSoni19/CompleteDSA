package binary;

public class RoseGarden {

    // Function to check if it is possible to make m bouquets in 'day' days
    public static boolean possible(int arr[], int day, int m, int k) {
        int n = arr.length; // Length of the array
        int cnt = 0; // Counter for consecutive flowers that can be picked
        int nofB = 0; // Number of bouquets made

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++; // Increment counter if the flower can be picked on 'day'
            } else {
                nofB += (cnt / k); // Calculate number of bouquets from consecutive flowers
                cnt = 0; // Reset counter if a flower cannot be picked
            }
        }
        // Add any remaining bouquets that can be made from the last sequence of flowers
        nofB += (cnt / k);

        // Return true if the number of bouquets made is at least m
        return nofB >= m;
    }

    // Function to find the minimum number of days required to make m bouquets
    public static int flowers(int arr[], int k, int m) {
        long val = (long) k * m; // Total number of flowers needed
        int n = arr.length; // Length of the array
        if (val > n) return -1; // If not enough flowers, return -1

        int mini = Integer.MAX_VALUE; // Initialize mini to the maximum possible integer value
        int maxi = Integer.MIN_VALUE; // Initialize maxi to the minimum possible integer value

        // Loop through the array to find the minimum and maximum values
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]); // Update mini to the smallest value found
            maxi = Math.max(maxi, arr[i]); // Update maxi to the largest value found
        }

        // Set the initial search range for binary search
        int low = mini, high = maxi;

        // Perform binary search to find the optimal value
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the midpoint of the current range

            // Check if it is possible to achieve the goal with the current midpoint value
            if (possible(arr, mid, m, k)) {
                high = mid - 1; // If possible, try a smaller value
            } else {
                low = mid + 1; // If not possible, try a larger value
            }
        }

        return low; // The minimum number of days required to make m bouquets
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        System.out.println(flowers(arr, k, m));
    
    
    }
}
