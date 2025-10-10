package BitManipulation;

public class Clearithbit {
    public static void main(String[] args){
        int n=13;
        int i=2;
        int a=n&~(1<<i);
        System.out.println(a);
    }
}
