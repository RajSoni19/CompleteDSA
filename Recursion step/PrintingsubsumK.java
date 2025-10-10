import java.util.ArrayList;
import java.util.List;

public class PrintingsubsumK {

    public static List<List<Integer>> findsubK(int num[],int sum){
            List<List<Integer>> result=new ArrayList<>();
            List<Integer> dum=new ArrayList<>();
            sumk(0,num,sum,dum,result,0);
            return result;
    }

    public static boolean  sumk(int i,int num[],int sum,List<Integer> dum,List<List<Integer>> result,int s){
        // int s=0;
        if(i==num.length){
           if(s==sum){
              result.add(new ArrayList<>(dum));
              return true;
            }
            else return false;
        }

        dum.add(num[i]);
        s+=num[i];
        if(sumk(i+1,num,sum,dum,result,s)) return true;
        s-=num[i];
        dum.remove(dum.size()-1);
        if(sumk(i+1,num,sum,dum,result,s)) return true;

        return false;
        
    }
    public static void main(String[] args) {
         List<List<Integer>> f=new ArrayList<>();
        int nums[]={1,2,1};
        int sum=2;
        f=findsubK(nums,sum);
        System.out.println(f);
    }
}
