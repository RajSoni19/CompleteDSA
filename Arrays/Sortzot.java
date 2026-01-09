package Arrays;
public class Sortzot {
    
    //BETTER
    // public static void Sorted(int arr[],int n){
    //     int cnt0=0;
    //     int cnt1=0;
    //     int cnt2=0;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]==0) cnt0++;
    //         else if(arr[i]==1) cnt1++;
    //         else cnt2++;
    //     }
    //     for(int i=0;i<cnt0;i++){
    //        arr[i]=0;
    //     }
    //     for(int i=cnt0;i<cnt0+cnt1;i++){
    //        arr[i]=1;
    //     }
    //     for(int i=cnt0+cnt1;i<n;i++){
    //        arr[i]=2;
    //     }

    //     for(int i=0;i<n;i++){
    //         System.out.println(arr[i]);
    //     }
    // }

    //OPTIMAL

// We divide the array into three partitions using three pointers – low, mid, and high.
// From 0 to low-1, we’ll keep only 0s
// From low to mid-1, only 1s
// From high+1 to n-1, only 2
    public static void Sorted(int arr[],int n){
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
              // If current element is 0, swap with low and move both pointers forward
            if(arr[mid]==0){
               int temp=arr[low];
               arr[low]=arr[mid];
               arr[mid]=temp;
               low++;
               mid++;
            }

            // If arr[mid] == 1, it’s already in the middle section → just move mid.
            else if(arr[mid]==1){
                   mid++;
            }

            // If arr[mid] == 2, it belongs to the right section → swap with high, only move high.
            else{
                int t=arr[mid];
                arr[mid]=arr[high];
                arr[high]=t;
                high--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        int arr[]={0,1,2,0,1,1,0,2};
        int n=arr.length;
        Sorted(arr,n);
    }
}
