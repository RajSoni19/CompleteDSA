
import java.util.Arrays;

public class JCArrayClass {
    public static void main(String[] args) {
        // int arr[]={1,2,3,4,5};
        // int idx=Arrays.binarySearch(arr, 3);
        // System.out.println("The index of element 3 is" + idx);
        
        int arr[]={9,2,3,4,5};
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){

            System.out.println(arr[i]);
        }
        for(int i:arr){
            System.out.println(i);
        }
    }
    
}
