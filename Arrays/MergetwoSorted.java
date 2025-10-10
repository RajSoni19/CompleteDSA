package Arrays;
import java.util.*;

public class MergetwoSorted {
    public static void Merges(long arr1[],int n,long arr2[],int m){
        int left=n-1;
        int right=0;
        while(left>=0&&right<m){
            if(arr1[left]>arr2[right]){
                long temp=arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        // for(int i=0;i<=n+m;i++){
        //     arr1[i]=arr1[i]+arr2[i];
        //     System.out.println(arr1[i]);
        // }
        
        

    }
    public static void main(String[] args) {
        long arr1[]={1,5,6};
        long arr2[]={2,3,4};
        int n=arr1.length;
        int m=arr2.length;
        Merges(arr1, n, arr2, m);
        
    }
}
