package Arrays;

public class StockBuySell {

    public static void Stock(int num[],int n){
      int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(num[i],min);
            max=Math.max(num[i]-min,max);
        }
        System.out.println(max);
    }
   public static void main(String[] args) {
       int num[]={7,1,5,3,6,4};
       int n=num.length;
       Stock(num,n);
   }   
}
