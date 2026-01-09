package Stack;

import java.util.*;

public class SumofSubMin {

    public static int[] findnse(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                ans[i] = n;
            else
                ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    public static int[] findpse(int arr[]) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >arr[i]) {
                s.pop();
            }

            if (s.isEmpty())
                ans[i] = -1;
            else
                ans[i] = s.peek();

            s.push(i);
        }
        return ans;

    }

    public static int getminimum(int arr[]) {
        int sum = 0;
        int n = arr.length;

        // BRUTE FORCE
        // for(int i=0;i<n;i++){
        // int mini=arr[i];
        // for(int j=i;j<n;j++){
        // mini=Math.min(mini, arr[j]);
        // sum+=mini;
        // }
        // }
        // return sum;

        int []nse=findnse(arr);
        int []pse=findpse(arr);

         int mod = (int)1e9 + 7;
        for(int i=0;i<n;i++){ 
            int left=i-pse[i];
            int right=nse[i]-i;
            int freq=left*right;
            int val=freq*arr[i];
            sum+=val;
        }
        return sum;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 5 };
        System.out.println(getminimum(arr));
    }
}
