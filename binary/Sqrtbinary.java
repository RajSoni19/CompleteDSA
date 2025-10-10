package binary;

public class Sqrtbinary {
    public static int Sqrtb(int x){
        int low=0;
        int high=x;
        while(low<=high){
           int mid=(low+high)/2;
           if(mid*mid<=(long)x){
                low=(int)mid+1;
           }
           else{
            high=(int)mid-1;
           }
        }
        return high;
    }

    public static void main(String[] args) {
        int x=28;
        System.out.println(Sqrtb(x));
    }
    
}
