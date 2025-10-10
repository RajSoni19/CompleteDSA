import java.util.*;

public class Combinationsum2 {

    public static List<List<Integer>> comb2(int arr[],int target){
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        findcomb(0,result,new ArrayList<>(),target,arr);
        return result;
    }

    public static void findcomb(int i,List<List<Integer>> result,List<Integer> ds,int target,int arr[]){
       
            if(target==0){
                result.add(new ArrayList<>(ds));
                  return;
            }
         

        for(int j=i;j<arr.length;j++){

            if(j>i && arr[j]==arr[j-1]) continue;
            if(arr[j]>target) break;
           ds.add(arr[j]);
           findcomb(j+1, result, ds, target-arr[j], arr);
           ds.remove(ds.size()-1);
        }


    }
    public static void main(String[] args) {
        List<List<Integer>> result=new ArrayList<>();
        int arr[]={10,1,2,7,6,1,5};
        int target=8;
        result=comb2(arr,target);
        System.out.println(result);
    }
}
