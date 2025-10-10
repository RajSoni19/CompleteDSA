package BitManipulation;

public class CheckithbitSet {

    public static boolean checkbit(int n,int i){
        // return (n&(1<<i))!=0; //for left shift
        return ((n>>i)&1)!=0;  //for right shift
    }
    public static void main(String[] args) {
        int n=13;
        int i=1;
        if(checkbit(n,i)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
