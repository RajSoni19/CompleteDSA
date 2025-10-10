package recursion;



public class Reclevel {
    // public static void f(int i,int arr[],int n){
    //   if(i<n){
    //     int temp=arr[i];
    //     arr[i]=arr[n];
    //     arr[n]=temp;
    //    f(i+1,arr,n-1);
    //   }
     
    //  }
    //  static void print(int ans[],int n){
    //     System.out.println("Reverse");
    //     for(int i=0;i<n;i++){
    //         System.out.println(ans[i]);
    //     }
    //  }
    //  public static void reverse(int arr[],int n){
    //     int ans[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         ans[i]=arr[n-i-1];     
    //     }
    //     print(ans,n);
    //  }

    // public static boolean ff(int i,String s){
    //     if(i>=s.length()/2) return true;
    //     if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
    //     return ff(i+1,s);
    // }

    public static boolean Check(String g){
        int left=0;
        int right=g.length()-1;
        while(left<right){
            char l=g.charAt(left);
            char r=g.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }
            else if(!Character.isLetterOrDigit(r)){
                right--;
            }
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                return false;
            }
            else{
                left++;
                right--;
            }
          
            
        }
        return true;
    }
    public static void main(String[] args) {
        // int arr[]={1,2,3,4,5};
        // int n=arr.length;

        //Normal
        //reverse(arr, n);

        //Using Recursion reverse array
        // f(0,arr,n-1);
        // for(int i=0;i<n;i++){
        //     System.out.println(arr[i]);
        // }
          
        // Palidrome String using recursiom
        // String s="madam";
        // System.out.println(ff(0,s));
    
        //Palidrome Sring 
        String g="madam";
        System.out.println(Check(g));

    }
}
