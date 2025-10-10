package BitManipulation;

public class Convert2Binary {
    public static void main(String[] args) {
        int n=13;
        String res="";
        while(n>0){

            if(n%2==1){
                 res+="1";
            } else {
                res+="0";
            }
            n=n/2;
        }
        StringBuilder s=new StringBuilder(res);
        s.reverse();
        System.out.println(s.toString());
    }
}
