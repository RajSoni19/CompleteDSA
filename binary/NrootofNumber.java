package binary;

public class NrootofNumber {

    // Helper function to check if mid^n is equal to, less than, or greater than m
    public static int func(int mid, int n, int m){
        long ans = 1; // Variable to store mid raised to the power n
        for(int i = 1; i <= n; i++){
            ans = ans * mid; // Multiply mid n times
            if(ans > m){
                return 2; // If ans exceeds m, return 2
            }
        }
        if(ans == m) return 1; // If ans equals m, return 1
        return 0; // If ans is less than m, return 0
    }

    // Function to find the nth root of m using binary search
    public static int NthRoot(int n, int m){
        int low = 0;
        int high = m;
        while(low <= high){
            int mid = (low + high) / 2; // Calculate mid value
            int midN = func(mid, n, m); // Check mid^n compared to m
            if(midN == 1){
                return mid; // If mid^n == m, mid is the answer
            }
            else if(midN == 0){
                low = mid + 1; // If mid^n < m, search right half
            }
            else{
                high = mid - 1; // If mid^n > m, search left half
            }
        }
        return -1; // If no integer root found, return -1
    }

    public static void main(String[] args) {
        int n = 3, m = 27; // Example: Find the 3rd root of 27
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans); // Output the result
    }
}