package BitManipulation;

public class XORfromLR {

    public static int XORr(int n){
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 3;
        return  n; 
    }

    public static int sol(int l,int r){
        return XORr(l-1)^XORr(r);
    }
    public static void main(String[] args) {
        int l=3;
        int r=5;


        int ans=sol(l,r);
        System.out.println(ans);
        //Brute 
        // int ans=0;
        // for(int i=l;i<=r;i++){
        //  ans^=i;
        // }
        // System.out.println(ans);
    }
}
