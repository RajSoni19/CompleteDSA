import java.util.*;

public class Combinationsum3 {
    
    public static void backtrack(int start,int k,int n,List<Integer> path,List<List<Integer>> ans){
        if(path.size()==k){
            if(n==0){
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=start;i<=9;i++){
            if(i>n) break;
            path.add(i);
            backtrack(i+1, k, n-i, path, ans);
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args) {
        int n=7,k=3;
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(),ans);
        System.out.println(ans);
    }
}
