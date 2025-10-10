
public class countsubseq {
    //  public static  findsubK(int num[],int sum){
    //         List<List<Integer>> result=new ArrayList<>();
    //         List<Integer> dum=new ArrayList<>();
    //         sumk(0,num,sum,dum,result,0);
    //         return result;
    // }

    public static int  findsubK(int i,int num[],int sum,int s){
        // int s=0;
        if(i==num.length){
           if(s==sum){
              return 1;
            }
             return 0;
        }

        // dum.add(num[i]);
        s+=num[i];
        int l=(findsubK(i+1,num,sum,s)) ;
        s-=num[i];
        // dum.remove(dum.size()-1);
        int r=(findsubK(i+1,num,sum,s)) ;

        return l+r;
        
    }
    public static void main(String[] args) {
        //  List<List<Integer>> f=new ArrayList<>();
        int nums[]={1,2,1};
        int sum=2;
        int f=findsubK(0,nums,sum,0);
        System.out.println(f);
    }
}
