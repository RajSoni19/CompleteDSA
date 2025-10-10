package Recursion step;

public class CountGoodNumber {

    public static long modpow(long base,long exp,long mod){
        long result=1;
        base=base%mod;
        while(exp>0){
            if((exp&1)==1){
                result=(result*base)%mod;
            }
            base=(base*base)%mod;
            exp>>=1;
        }
        return result;
    }

    public static void counttotal(long n){
        long x=(n+1)/2;
        long y=n/2;
        long ans=(modpow(5,x,1000000007)*modpow(4,y,1000000007))%1000000007;
        System.out.println(ans);
    }
    public static void main(String[] args) {
        counttotal(1);

    }
}
