package TwoPointerSlidingWindow;

import java.util.*;

public class Subarrdiffinteger{

    public static int atmostk(int arr[],int k){
        int left=0;
        int cnt=0;
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
          map.put(arr[right],map.getOrDefault(arr[right], 0)+1);

          while(map.size()>k){ //sliding window 
            map.put(arr[left],map.get(arr[left])-1);
            if(map.get(arr[left])==0){
                map.remove(arr[left]);
            }
            left++;
          }
          cnt+=(right-left+1);
        }
        return cnt;
    }

    public static int finalans(int arr[],int k){
        return atmostk(arr, k)-atmostk(arr, k-1);
    }


    public static void main(String[] args) {
        int arr[]={1,2,1,2,3};
        int k=2;
        System.out.println(finalans(arr,k));
    }
}