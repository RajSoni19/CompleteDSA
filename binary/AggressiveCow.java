package binary;
import java.util.*;

public class AggressiveCow {

    // Function to check if we can place 'cows' cows in stalls with at least 'dist' distance apart
    public static boolean canweplace(int stalls[], int dist, int cows) {
        int cntcows = 1; // Place the first cow in the first stall
        int last = stalls[0]; // Last stall where a cow was placed
        int n = stalls.length;
        for (int i = 1; i < n; i++) {
            // If the current stall is at least 'dist' away from the last cow
            if (stalls[i] - last >= dist) {
                cntcows++; // Place another cow
                last = stalls[i]; // Update last placed position
            }
            if (cntcows >= cows) return true; // If all cows placed, return true
        }
        return false; // Not possible to place all cows with at least 'dist' distance
    }

    // Function to find the largest minimum distance possible between any two cows
    public static int aggressiveCows(int stalls[], int k) {
        Arrays.sort(stalls); // Sort the stall positions
        int low = 0;
        int n = stalls.length;
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        while (low <= high) {
            int mid = (low + high) / 2; // Try for the middle distance
            if (canweplace(stalls, mid, k) == true) {
                low = mid + 1; // Try for a bigger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }
        return high; // The largest minimum distance possible
    }

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9}; // Stall positions
        int k = 4; // Number of cows
        System.out.println(aggressiveCows(stalls, k)); // Output the result
    }
}