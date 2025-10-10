package Recursion step;

public class ppow {

    public static double mypow(double x,double n){
        double ans=1.0;
        double nn=n;
        if(nn<0) nn=-1*nn;
        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn=nn-1;
            }
            else{
                x=x*x;
                nn=nn/2;
            }
        }

        if(n<0) ans=(double)(1.0)/(double)(ans);
        return ans;
    }


    public static void main(String[] args) {
        double x=2.0000;
        double n=10;
        double result=mypow(x,n);
        System.out.println(result);
    }
}
