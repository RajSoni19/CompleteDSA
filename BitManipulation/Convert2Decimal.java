package BitManipulation;

public class Convert2Decimal {
    public static void main(String[] args) {
       String s="1101";
       int len=s.length();
       int num=0;
       int p2=1;
       for(int i=len-1;i>=0;i--){
        if(s.charAt(i)=='1'){
          num=num+p2;
        }
        p2=p2*2;
       }

       System.out.println(num);
    }
}
