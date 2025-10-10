
import java.util.Scanner;

public class Patterns{

    //Pattern 1 (Square)
    //public static void print1(int n){
        // for(int i=0;i<4;i++){
        //     for(int j=0;j<4;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    //}

        //pattern2
        // *
        // **
        // ***
        // ****
        // *****
        // public static void print2(int n){
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // Inverted Star(pattern 3)
    //     public static void print3(int n){
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=n-i+1;j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }

        //Half pyramid(numbers)
        // public static void print4(int n){
        //     for(int i=1;i<=n;i++){
        //         for(int j=1;j<=i;j++){
        //             System.out.print(j);
        //         }
        //         System.out.println();
        //     }
        // }

        //Charcter pattern
        // public static void print5(int n){
        //     char ch='A';
        //     for(int i=1;i<=n;i++){
        //         for(int j=1;j<=i;j++){
        //                 System.out.print(ch);
        //                 ch++;  
        //         }
        //         System.out.println();
        //     }
        // }

        //Hollow Rectangle 
        public static void print6(int n){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==1 || j==1 || i==n || j==n){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        //Inverted and rotated half pyramid
        public static void print7(int n){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n-i;j++){
                 System.out.print(" ");
                }
                 for(int j=1;j<=i;j++){
                    System.out.print("*");
                 }
                 System.out.println();
                  
            }
        }

        //Inverted half pyramid(number)
        public static void print8(int n){
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n-i+1;j++){
                        System.out.print(j);
                    }
                    System.out.println();
                }
            }
        
        //Floyds Triangle
        public static void print9(int n){
            int k=1;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(k + " ");
                    k++;
                }
                System.out.println();
            }
        }

        //0-1 Triangle
        public static void print10(int n){
                for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
              if((i+j)%2==0){
                System.out.print("1");
              }
              else{
                System.out.print("0");
              }
            }
            System.out.println();
           }
        }

        //Butterfly
        public static void print11(int n){
            //1st Half
            for(int i=1;i<=n;i++){
                    //stars -i 
                    for(int j=1;j<=i;j++){
                        System.out.print("*");
                    }
                    //spaces -2*(n-i)
                    for(int j=1;j<=2*(n-i);j++){
                        System.out.print(" ");
                    }
                    //stars - i
                    for(int j=1;j<=i;j++){
                        System.out.print("*");
                    }
                    System.out.println();
            }
              //2nd half
            for(int i=n;i>=1;i--){
                 //stars -i 
                 for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                //spaces -2*(n-i)
                for(int j=1;j<=2*(n-i);j++){
                    System.out.print(" ");
                }
                //stars - i
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                System.out.println();
            }}

        // Solid Rohmbas
         public static void print12(int n){
           for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
           }
         }

        //Hollow Rohmbus
        public static void print13(int n){
            for(int i=1;i<=n;i++){
                    for(int j=1;j<=n-i;j++){
                        System.out.print(" ");
                    }
                   for(int j=1;j<=n;j++){
                    if(i==1 || j==1 || i==n || j==n){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                   }
                   System.out.println(); 
        }
    }

    //Diamond Pattern
    public static void print14(int n){
         for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
         }
         for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
         }
    }


     public static void main(String[] args){
       
       Scanner sc=new Scanner(System.in);
    //    int n=sc.nextInt();
    int n=5;
       print14(n); 
    }
        
}
