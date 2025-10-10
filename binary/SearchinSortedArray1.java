package binary;
public class SearchinSortedArray1 {
    public static void s(int arr[],int k){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==k){
                System.out.println(mid);
                return;
            }
            if(arr[low]<=arr[mid]){
               if(arr[low]<=k&&k<=arr[mid]){
                high=mid-1;
               }
               else{
                low=mid+1;
               }
            }
            else{
                if(arr[mid]<=k&&k<=arr[high]){
                       low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }

    }
    public static void main(String[] args) {
        int a[]={4,5,6,7,0,1,2,3};
        int k = 0;
        s(a, k);
    }
}
