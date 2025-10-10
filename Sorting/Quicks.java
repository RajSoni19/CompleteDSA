package Sorting;

public class Quicks {
    public static int  partition(int arr[],int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot&&i<=high-1){
                i++;
            }
            while(arr[j]>pivot&&j>=low+1){
                j--;
            }
            if(i<j) {  
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
        }
    public static void Quick(int arr[],int low,int high){
            if(low<high){
                int pindex=partition(arr, low, high);
                Quick(arr, low,pindex-1);
                Quick(arr, pindex+1, high);
            }
    }
    public static void main(String[] args) {
        int arr[]={3,5,2,9,4};
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Sorted");
        Quick(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }
}
