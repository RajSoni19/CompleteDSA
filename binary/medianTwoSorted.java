package binary;

public class medianTwoSorted {

    // Function to find the median of two sorted arrays using binary search
    public static double median(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        // Ensure that 'a' is the smaller array for efficient binary search
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; // Total number of elements
        int left = (n1 + n2 + 1) / 2; // Number of elements in the left partition

        int low = 0;
        int high = n1;

        // Binary search on the smaller array
        while (low <= high) {
            int mid1 = (low + high) / 2; // Partition in array 'a'
            int mid2 = left - mid1;      // Partition in array 'b'

            // Get the border elements for comparison, handle out-of-bounds with MIN/MAX
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            // Check if correct partition is found
            if (l1 <= r2 && l2 <= r1) {
                // If total number of elements is odd, median is max of left elements
                if (n % 2 == 1) return Math.max(l1, l2);
                // If even, median is average of max of left and min of right
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1; // Move partition in 'a' to the left
            } else {
                low = mid1 + 1; // Move partition in 'a' to the right
            }
        }
        return 0; // Should not reach here if input arrays are valid
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}