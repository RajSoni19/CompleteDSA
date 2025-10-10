package recursion;

public class ParaRec {
    // public static void sumP(int i,int sum){
    //   if(i<1){
    //     System.out.println(sum);
    //       return;
    //   }
    //   sumP(i-1, sum+i);
    // }

    public static int sum(int n){
      if(n==0){
        return 0;
      }
      return n+sum(n-1);
    }

    public static int fact(int n){
      if(n==0){
        return 1;
      }
      return n*fact(n-1);
      
    }
    public static void main(String[] args) {
        //Parameter way to summation n=3--> 3+2+1=6
        //sumP(3,0);

        //Funtional way 
        int a=sum(3);
        System.out.println(a);

        //Factorial of number
        // int a =fact(5);
        // System.out.println(a);
    }
}
