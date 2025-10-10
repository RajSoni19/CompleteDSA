// package Recursion Step;
import java.util.*;

public class Subset2 {

    public static List<List<Integer>> findsub(int nums[]){
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,ans,new ArrayList<>(),nums);
        return ans;
    }

    public static void helper(int ind,List<List<Integer>> ans,List<Integer> ds,int nums[]){
           ans.add(new ArrayList<>(ds));
           for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1,ans,ds,nums);
            ds.remove(ds.size()-1);
           }
    }
    public static void main(String[] args) {
        List<List<Integer>> ans=new ArrayList<>();
        int nums[]={1,2,3};
        ans=findsub(nums);
        System.out.println(ans);

    }
}
