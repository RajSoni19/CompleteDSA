package BitManipulation;

public class TwoUniquenum {

    public static int[] xorconcept(int nums[]){
        int n=nums.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor=xor^nums[i];
        }

        int rightmost=(xor&xor-1)^xor;

        int xor1=0;
        int xor2=0;

        for(int i=0;i<n;i++){
            if((nums[i]&rightmost)!=0){
               xor1=xor1^nums[i];
            }
            else{
                xor2=xor2^nums[i];
            }
        }

        if(xor1<xor2) return new int[]{xor1,xor2};
        return new int[]{xor2,xor1};

    }

    // public static List<Integer> brutenumsunique(int nums[]){
    //     HashMap<Integer,Integer> mpp=new HashMap<>();
    //     List<Integer> ans=new ArrayList<>();
        
    //     for(int num:nums){
    //         mpp.put(num, mpp.getOrDefault(num, 0)+1);
    //     }

    //     for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
    //         if(entry.getValue()==1){
    //             ans.add(entry.getKey());
    //         }
    //     }

    //     Collections.sort(ans);
    //     return ans;
    // }
    public static void main(String[] args) {
        int nums[]={1,2,1,3,5,2};
        // List<Integer> ans =brutenumsunique(nums);
        int ans[]=xorconcept(nums);
        System.out.println(ans[0]+" "+ans[1]);
    }

}
