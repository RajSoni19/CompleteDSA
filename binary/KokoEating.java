package binary;

public class KokoEating {

    public static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    
    // Function to calculate the total hours required to eat all bananas at a given eating speed 'h'
    public static int findTotalhr(int arr[], int h) {
        int totals = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Calculate the hours needed to eat arr[i] bananas at speed 'h' and add to totals
            totals += Math.ceil((double)(arr[i]) / (double)(h));
        }
        return totals;
    }
    
    // Function to find the minimum eating speed such that Koko can eat all bananas within 'h' hours
    public static int Kokoseat(int arr[], int h) {
        int low = 0;
        int high = findMax(arr); // Maximum possible eating speed
        while (low <= high) {
            int mid = (low + high) / 2; // Midpoint of current range of speeds
            int total = findTotalhr(arr, mid); // Total hours needed at speed 'mid'
            if (total <= h) {
                // If total hours is less than or equal to 'h', try a slower speed
                high = mid - 1;
            } else {
                // If total hours is more than 'h', try a faster speed
                low = mid + 1;
            }
        }
        return low; // The minimum speed at which Koko can eat all bananas within 'h' hours
    }
    public static void main(String[] args) {
        int arr[]={3,6,7,11};
        int h=8;
        System.out.println(Kokoseat(arr,h));
    }
}
