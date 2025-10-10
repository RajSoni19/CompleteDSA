package Strings;
public class Palidrome {

    public static boolean pali(String s){

        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                   return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s="racecar";
        boolean res=pali(s);
        System.out.println(res);
    }
}
