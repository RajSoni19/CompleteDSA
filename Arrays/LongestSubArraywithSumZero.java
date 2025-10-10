package Arrays;

import java.util.*;

public class LongestSubArraywithSumZero {

    // Function to find the length of the longest subarray with sum zero
    public static int SubArray(int arr[], int n) {
        HashMap<Integer, Integer> mpp = new HashMap<>(); // Map to store prefix sum and its earliest index
        int sum = 0;   // Current prefix sum
        int maxi = 0;  // Maximum length found so far

        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Update prefix sum

            if (sum == 0) {
                // If sum is zero, subarray from 0 to i has sum zero
                maxi = i + 1;
            } else {
                // If this sum has been seen before, subarray between previous index+1 and i has sum zero
                if (mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    // Store the first occurrence of this sum
                    mpp.put(sum, i);
                }
            }
        }
        return maxi; // Return the maximum length found
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, -2, 4, -4};
        int n = arr.length;
        int a = SubArray(arr, n);
        System.out.println(a); // Output the result
    }
}