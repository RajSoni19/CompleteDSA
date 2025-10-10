package Arrays;

import java.util.*;

public class TwoSum{
    public static void TwoSumI(int arr[], int target) {
        int n = arr.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1; // Default values indicating no solution
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int need = target - num;

            // Check if the complement exists in the map
            if (map.containsKey(need)) {
                ans[0] = map.get(need); // Index of the complement
                ans[1] = i;            // Current index
                System.out.println("Pair found at indices: " + ans[0] + ", " + ans[1]);
                return;
            }

            // Add the current number and its index to the map
            map.put(arr[i], i);
        }

        // No solution found
        System.out.println("No pair found. Indices: " + ans[0] + ", " + ans[1]);
    }

   


    public static void TwoSumYN(int arr[],int target){
              int n=arr.length;
              int left=0;
              int right=n-1;
              Arrays.sort(arr);
              while(left<right){
                int sum=arr[left]+arr[right];
                if(sum==target) System.out.println("YES");
                if(sum<target) left++;
                else right--;
              }
    }
    public static void TwoSum(int arr[],int target){
              // ArrayList<Integer> ans=new ArrayList<>();
              int n=arr.length;
              int left=0;
              int right=n-1;
              Arrays.sort(arr);
              while(left<right){
                int sum=arr[left]+arr[right];
                if(sum==target){
                    
                 System.out.println(arr[left]+" "+ arr[right]);
                  return;
                }
                if(sum<target) left++;
                else right--;
              }
              // System.out.println(ans);
    }
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        int target=9;
        TwoSumI(arr,target);
        TwoSumYN(arr,target);
        TwoSum(arr, target);
    }
}