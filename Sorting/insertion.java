package Sorting;

public class insertion{
    public static void insertionSort(int arr[],int n){
       for(int i=0;i<=n-1;i++){
        int j=i;
        while(j>0 && arr[j-1]>arr[j]){
            int temp=arr[j-1];
            arr[j-1]=arr[j];
            arr[j]=temp;
            j--;
        }
       }
    }
    public static void main(String[] args) {
        int arr[]={4,2,1,90,9};
        int n=arr.length;
        // System.out.println(n);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        insertionSort(arr,n);
        System.out.println("Sorted");
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }

    }
}
