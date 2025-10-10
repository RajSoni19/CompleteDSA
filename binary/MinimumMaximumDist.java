package binary;
public class MinimumMaximumDist{

    // Function to count how many gas stations are needed for a given minimum distance 'dist'
    public static int numberofGas(double dist, int arr[]){
        int n = arr.length;
        int cnt = 0; // Counter for required gas stations
        for(int i = 1; i < n; i++){
            int numberBetween = (int)((arr[i] - arr[i-1]) / dist); // Number of stations needed between arr[i-1] and arr[i]
            // If the distance divides exactly, reduce by one (no need for extra station at the end)
            if(arr[i] - arr[i-1] == (dist * numberBetween)){
                numberBetween--;
            }
            cnt += numberBetween; // Add to total count
        }
        return cnt;
    }

    // Function to minimize the maximum distance between gas stations after adding k new stations
    public static double minimiseMaxDistance(int arr[], int k){
        double low = 0;
        double high = 0;
        int n = arr.length;
        // Find the maximum initial distance between consecutive stations
        for(int i = 0; i < n - 1; i++){
            high = Math.max(high, (double)(arr[i+1] - arr[i]));
        }
        double diff = 1e-6; // Precision for binary search
        // Binary search to find the minimum possible maximum distance
        while(high - low > diff){
            double mid = (low + high) / 2;
            int cnt = numberofGas(mid, arr); // Number of stations needed for distance 'mid'
            if(cnt > k){
                low = mid; // Too many stations needed, increase distance
            }
            else{
                high = mid; // Possible to do with k or fewer stations, try smaller distance
            }
        }
        return high; // The minimized maximum distance
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Initial gas station positions
        int k = 4; // Number of new stations to add
        double ans = minimiseMaxDistance(arr, k); // Find minimized maximum distance
        System.out.println(ans); // Output the result
    }   
}