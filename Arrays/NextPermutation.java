package Arrays;

public class NextPermutation {

    public static void reverse(int arr[],int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

       public static void next(int arr[],int n){
          int ind=-1;
          for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
          }
          if(ind==-1) {
            reverse(arr, 0, n-1);
            return;
          }
          for(int i=n-1;i>ind;i--){
            if(arr[i]>arr[ind]){
                int temp=arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;
                break;
            }
          }
          reverse(arr, ind+1, n-1);
          for(int i=0;i<n;i++){
            System.out.println(arr[i]);
          } 
       }
        public static void main(String[] args) {
        int arr[]={3,1,2};
        int n=arr.length;
        next(arr,n);
    }
}
