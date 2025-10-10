package recursion;

public class basicRec {
    // static int c=1;
    // public static void printname(int n){
    //  if(n==0){
    //     return;
    //  }
    //  System.out.println("Raj");
    //  printname(n-1);
    // }
    
    // public static void f(int n){ 
    //     if(c==n+1){
    //         return;
    //     }
    //    System.out.println(c);
    //    c++;
    //    f(n);
    // }

    public static void ff(int n){

         if(n==0){
            return;
         }
         System.out.println(n);
         ff(n-1);

    }
    public static void main(String[] args) {
    // 1 to N printing lec-1
    //  f(4);

    // print N times names
    // printname(4);

    //print N to 1 numbers
     ff(5);
    }
}
