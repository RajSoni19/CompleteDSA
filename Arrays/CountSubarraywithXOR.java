package Arrays;
import java.util.*;
// import javax.management.modelmbean.ModelMBeanOperationInfo;

// import java.util.*;

public class CountSubarraywithXOR{

     public static int CountXOR(int a[],int k){
        int n=a.length;
        int cnt=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int xr=0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            xr=xr^a[i];
            int x=xr^k;
            if(mpp.containsKey(x)){
                cnt+=mpp.get(x);
            }
            if(mpp.containsKey(xr)){
                mpp.put(xr,mpp.get(xr)+1);
            }
            else{
                mpp.put(xr,1);
            }
            }

            return cnt;
        }

     
    public static void main(String[] args) {
        int a[] = {4, 2, 2, 6, 4};
        int k = 6;
        int ar=CountXOR(a,k);
        System.out.println(ar);
    }
}