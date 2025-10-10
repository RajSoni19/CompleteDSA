package binary;

public class Shippingship {

    // Function to find the number of days required to ship all weights with a given capacity 'c'
    public static int findDays(int weights[], int c) {
        int days = 1; // Initialize the number of days to 1
        int load = 0; // Initialize the current load to 0
        int n = weights.length; // Length of the weights array

        for (int i = 0; i < n; i++) {
            if (load + weights[i] > c) {
                // If adding the current weight exceeds the capacity, increment the day count
                days += 1;
                // Start a new load with the current weight
                load = weights[i];
            } else {
                // Otherwise, add the current weight to the current load
                load += weights[i];
            }
        }
        return days; // Return the total number of days required
    }

    // Function to find the least capacity required to ship all weights within 'd' days
    public static int leastCapacity(int weights[], int d) {
        int n = weights.length; // Length of the weights array
        int low = Integer.MIN_VALUE; // Initialize low to the minimum possible integer value
        int high = 0; // Initialize high to 0

        // Loop through the array to find the minimum and maximum possible capacities
        for (int i = 0; i < n; i++) {
            low = Math.max(weights[i], low); // Update low to the maximum weight in the array
            high = high + weights[i]; // Update high to the sum of all weights in the array
        }

        // Perform binary search to find the optimal capacity
        while (low <= high) {
            int mid = (low + high) / 2; // Calculate the midpoint of the current range
            int nodays = findDays(weights, mid); // Find the number of days required with capacity 'mid'

            if (nodays <= d) {
                // If the number of days is less than or equal to 'd', try a smaller capacity
                high = mid - 1;
            } else {
                // If the number of days is more than 'd', try a larger capacity
                low = mid + 1;
            }
        }

        return low; // Return the least capacity required to ship all weights within 'd' days
    }
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        System.out.println(leastCapacity(weights,d));
    }
}
