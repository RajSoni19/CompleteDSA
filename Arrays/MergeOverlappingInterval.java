package Arrays;
import java.util.*;
public class MergeOverlappingInterval{

    public static int[][] overlap(int arr[][],int n){
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){ 

            // if the list is empty or the current interval does not overlap with the previous, simply append it.
            if(ans.isEmpty()||arr[i][0]>ans.get(ans.size()-1)[1]){
                  ans.add(new int[]{arr[i][0],arr[i][1]});
            }

            // otherwise, there is overlap, so we merge the current and previous intervals.
            else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }
           return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int arr[][]={{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int n=arr.length;
        int ar[][]=overlap(arr,n);
        for(int inte[]:ar){
            System.out.println(inte[0]+" "+inte[1]);
        }

    }
}