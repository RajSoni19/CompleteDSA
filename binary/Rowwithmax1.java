package binary;

import java.util.*;

public class Rowwithmax1 {

    public static int lowerbound(ArrayList<Integer> arr,int n,int x){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=x){
                ans=mid;
                 high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int rowmax( ArrayList<ArrayList<Integer>> matrix,int n,int m){
             int cntmax=0;
             int index=-1;
             for(int i=0;i<n;i++){
                int cntone=m-lowerbound(matrix.get(i),m,1);
                if(cntone>cntmax){
                    cntmax=cntone;
                    index=i;
                }
             }
             return index;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3, m = 3;
        System.out.println(rowmax(matrix,n,m));
        
        
    }
}
