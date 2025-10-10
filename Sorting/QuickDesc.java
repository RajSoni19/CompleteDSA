package Sorting;

public class QuickDesc {

    public static int partition(int arr[],int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]>=pivot && i<=high-1){
                i++;
            }
            while(arr[j]<pivot && j>low+1){
                j--;
            }
            if(i<j){
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

    public static void qis(int arr[],int low,int high){
        if(low<high){
            int pidx=partition(arr,low,high);
            qis(arr,low,pidx-1);
            qis(arr,pidx+1,high);
        }
    }
    public static void main(String[] args) {
        int arr[]={5,2,1,9};
        int n=4;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Sorted");
        qis(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
        
    }
}
