
public class CheckexistsubwithsumK {
    //  public static  findsubK(int num[],int sum){
    //         List<List<Integer>> result=new ArrayList<>();
    //         List<Integer> dum=new ArrayList<>();
    //         sumk(0,num,sum,dum,result,0);
    //         return result;
    // }

    public static boolean  findsubK(int i,int num[],int sum,int s){
        // int s=0;
        if(i==num.length){
          return s==sum;
        }
        
        // dum.add(num[i]);
        s+=num[i];
        if(findsubK(i+1,num,sum,s)) return true ;
        s-=num[i];
        // dum.remove(dum.size()-1);
        if(findsubK(i+1,num,sum,s)) return true;
        
        
        return false;
        
    }
    public static void main(String[] args) {
        //  List<List<Integer>> f=new ArrayList<>();
        int nums[]={1,2,1};
        int sum=2;
        boolean s=findsubK(0,nums,sum,0);
        System.out.println(s ? "Yes" : "No");
    }
}
