package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BitPowerset {

    public static List<List<Integer>> getPowerSet(List<Integer> nums){
        int n=nums.size();
        int subsets=1<<n;
        List<List<Integer>> ans=new ArrayList<>();

        for(int num=0;num<subsets;num++){
             List<Integer> subset=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num & (1 << i)) != 0){
                    subset.add(nums.get(i));
                }
            }

            ans.add(subset);
        }

        return ans;

    }
    public static void main(String[] args) {
        List<Integer> nums=List.of(1,2,3);
        System.out.println(nums.size());
        List<List<Integer>> subsets=getPowerSet(nums);
        System.out.println(subsets);


    }
}
