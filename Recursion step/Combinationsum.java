import java.util.*;


public class Combinationsum {

    public static List<List<Integer>> combi(int arr[],int target){
            List<List<Integer>> result=new ArrayList<>();
            findcomb(0,arr,result,new ArrayList<>(),target);
            return result;

    }

    public static void findcomb(int i,int arr[],List<List<Integer>> result,List<Integer> ds,int target){
        if(i==arr.length){
            if(target==0){
            result.add(new ArrayList<>(ds));
            
            }
            return;
        }

        if(arr[i]<=target){
            ds.add(arr[i]);
            findcomb(i,arr,result,ds,target-arr[i]);
            ds.remove(ds.size()-1);
        }
        findcomb(i+1,arr,result,ds,target);

    }
    public static void main(String[] args) {
        int arr[]={2,3,6,7};
        int n=arr.length;
        int target=7;
        List<List<Integer>> ans=combi(arr,target);
        System.out.println(ans);
    }
}
