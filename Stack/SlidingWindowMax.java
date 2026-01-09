package Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public static int[] getmax(int arr[],int k){
        int n = arr.length;

        //BRUTE
        // if (k > n || k <= 0) {
        //     return new int[0];
        // }
        int nums[] = new int[n - k + 1];

        // for (int i = 0; i <= n - k; i++) {
        //     int maxi = arr[i];
        //     for (int j = i; j < i + k; j++) {
        //         maxi = Math.max(maxi, arr[j]);
        //     }
        //     nums[i] = maxi;
        // }

        // return nums;


        //OPTIMAL
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&dq.peekFirst()<=i-k){ //remove element outside window 
                dq.pollFirst(); 
            }
            while(!dq.isEmpty()&&arr[dq.peekLast()]<arr[i]){ //remove smaller element
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1){
                      nums[i - k + 1]=arr[dq.peekFirst()];
            }
        }

        return nums;

    }

    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(getmax(arr,k)));
       
    }
}
