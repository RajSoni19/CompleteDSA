package Arrays;

import java.util.ArrayList;

public class Leader {

    public static void lead(int arr[],int n){
        // int t[]=new int[n];
        //   int max=arr[n-1];
        //   int ind=0;
        //   t[ind++]=arr[n-1];
        //   for(int i=n-2;i>=0;i--){
        //     if(max>arr[i]){
        //         t[ind++]=arr[i];
        //         max=arr[i];
        //     }
        //   }
        //   for(int i=ind-1;i>=0;i--){
        //     System.out.println(t[i]);
        //   }
        ArrayList<Integer> ans=new ArrayList<>();
        int max=arr[n-1];
        ans.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
                max=arr[i];
            }
        }

       System.out.println(ans);
    } 
    public static void main(String[] args) {
        int arr[]={4,7,1,0};
        int n=arr.length; 
        lead(arr,n);
    }
}
