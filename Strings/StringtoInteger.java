package Strings;

public class StringtoInteger {
    public static int Atoi(String s){
        int INT_MAX=Integer.MAX_VALUE;
        int INT_MIN=Integer.MIN_VALUE;
        int i=0; int n=s.length(); int sign=1;
        int result=0;
        //1 Skip leading whitespaces
        while(i<n&&s.charAt(i)==' ') i++;

        //2 Check if there is a sign
        if(i<n && (s.charAt(i)=='-'||s.charAt(i)=='+')){
            sign=s.charAt(i)=='-'?-1:1;
            i++;
        }

        //3 Convert digits to interger
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            if(result>(INT_MAX-digit)/10){
                return sign==1 ? INT_MAX:INT_MIN;
            }
            result=result*10+digit;
            i++;
        }
        return sign*result;

    }

    public static void main(String[] args) {
        String s="00rr42";
        System.out.println(Atoi(s));

    }
    
}
