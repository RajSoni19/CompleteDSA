package binary;

public class KthRotatedplace {

    // Function to find the index of the minimum element in a rotated sorted array
    public static void place(int arr[]){
        int low = 0;
        int high = arr.length - 1;
        int index = -1; // To store index of minimum element
        int ans = Integer.MAX_VALUE; // To store minimum value found

        // Binary search to find the minimum element
        while(low <= high){
            int mid = (low + high) / 2;

            // If the current segment is sorted
            if(arr[low] <= arr[high]){
                if(arr[low] < ans){
                    index = low; // Update index if a new minimum is found
                    ans = arr[low];
                }
                break; // Minimum found, exit loop
            }

            // If left half is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] < ans){
                    index = low; // Update index if a new minimum is found
                    ans = arr[low];
                }
                low = mid + 1; // Search right half
            } else {
                // If right half is sorted
                if(arr[mid] < ans){
                    index = mid; // Update index if a new minimum is found
                    ans = arr[mid];
                }
                high = mid - 1; // Search left half
            }
        }
        System.out.println(index); // Print the index of minimum element
    }

    public static void main(String[] args) {
        int arr[] = {4,5,1,2,3};
        place(arr); // Call function to find minimum element index
    }
}