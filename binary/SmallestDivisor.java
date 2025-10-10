package binary;

public class SmallestDivisor {
    public static int finddiv(int arr[],int mid){
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            ans+=Math.ceil((double)(arr[i])/(double)(mid));
        }
        return ans;
    }

    public static int smallestDivisor(int []arr,int limit){
         int n=arr.length;
         if(n>limit) return -1;
         int maxi=Integer.MIN_VALUE;
         for(int i=0;i<n;i++){
            maxi=Math.max(maxi,arr[i]);
         }
         int low=0;
         int high=maxi;
         while(low<=high){
            int mid=(low+high)/2;
            if(finddiv(arr,mid)<=limit){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
         }
         return low;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        System.out.println(smallestDivisor(arr, limit));
    }
}
