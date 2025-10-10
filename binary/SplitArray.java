package binary;

public class SplitArray {

    public static int count(int mid,int a[]){
        int subarr=0;
        int n=a.length;
        int partition=1;
        for(int i=0;i<n;i++){
            if(subarr+a[i]<=mid){
                subarr+=a[i];
            }
            else{
                partition++;
                subarr=a[i];
            }
        }
        return partition;
    }

    public static int largestSubarraySumMinimized(int a[],int k){
        int low=a[0];
        int high=0;
        for(int i=0;i<a.length;i++){
            low=Math.max(low,a[i]);
            high+=a[i];
        }
       while(low<=high){
        int mid=(low+high)/2;
        int partition=count(mid,a);
        if(partition>k){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
       }
       return low;

    }
  public static void main(String[] args) {
    int[] a = {7,2,5,10,8};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println(ans);
  }
}
