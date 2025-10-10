package Strings;

public class RotateStr {

    public static boolean Rotate(String s,String goal){
        if(s.length()!=goal.length()){
            return false;
        }
        return (s+s).contains(goal);
    }
    public static void main(String[] args) {
        String s="abcde";
        String goal="cdeab";
        boolean a=Rotate(s,goal);
        System.out.println(a);
    }
}
