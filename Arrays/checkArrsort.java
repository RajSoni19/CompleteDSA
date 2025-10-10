package Arrays;

public class checkArrsort {
    public static void Sorted(int arr[],int n){
         for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                System.out.println("Not Sort");
                return; 
            }   
        }
        System.out.println("Sort");
          

    }
    public static void main(String[] args) {
        int arr[]={1,3,4,5};
        int n=arr.length;
        Sorted(arr,n);
    }
}
