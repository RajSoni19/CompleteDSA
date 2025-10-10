package Arrays;

import java.util.*;

public class ReversePair {

    public static void merge(int a[],int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid&&right<=high){
            if(a[left]<=a[right]){
                temp.add(left);
                left++;
            }
            else{
                temp.add(a[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(a[left]);
            left++;
        }
        while(right<=high){
            temp.add(a[right]);
            right++;
        }
       
        for(int i=low;i<=high;i++){
            a[i]=temp.get(i-low);
        }

    }

    //Counting Reversing Pair logic
     public static int countPairs(int a[],int low,int mid,int high){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high&&a[i]>2*a[right]){
                right++;
            }
                cnt += (right - (mid + 1));
        }
        return cnt;
     }

    public static int mergeSort(int a[],int low,int high){
        int cnt=0;
        if(low>=high) return cnt;
        int mid=(low+high)/2;
        cnt+=mergeSort(a,low,mid);
        cnt+=mergeSort(a,mid+1,high);
        cnt+=countPairs(a,low,mid,high);
        merge(a,low,mid,high);
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3, 1};
        int n = 5;
        int ns=mergeSort(a, 0, n-1);
        System.out.println(ns);
    }
}
