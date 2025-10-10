package binary;
public class SingleinSorted {

    // Function to find the single non-duplicate element in a sorted array
    public static int single(int arr[]){
        int n = arr.length;

        // Check if the first element is the single one
        if(arr[0] != arr[1]){
            return arr[0];
        }
        // Check if the last element is the single one
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }

        int low = 1;
        int high = n - 2;

        // Binary search for the single element
        while(low <= high){
            int mid = (low + high) / 2;

            // If arr[mid] is not equal to its neighbors, it's the single element
            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }   

            // Check the pattern to decide which half to search next
            // If mid is odd and equals previous, or mid is even and equals next, then search right half because left half will be eliminated
            if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid % 2 == 0 && arr[mid] == arr[mid+1])){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        // If no single element found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,5,5,6,6}; // Example input array
        System.out.println(single(arr)); // Output the single non-duplicate element
    }
}