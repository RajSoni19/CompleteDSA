package Arrays;

public class LinearSearch {
    public static void Linear(int arr[],int n,int t){
        for(int i=0;i<n;i++){
            if(arr[i]==t){
                System.out.println("Element found at index "+ i);
                return;
            }
        }
        System.out.println("Not present");
    }
    public static void main(String[] args) {
        int arr[]={8,4,5,6,3};
        int n=5;
        int t=3;
        Linear(arr,n,t);
    }
    
}
