package Arrays;

public class LargestEle {

    public static int Largest(int arr[],int n){
        int max=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[]={3,4,9,0,1};
        int n=arr.length;
        int m=Largest(arr, n);
        System.out.println(m);
    }
}
