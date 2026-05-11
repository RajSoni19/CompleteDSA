package Greedy;

public class isValidStr2 {

    // BRUTE force
    // public static boolean isvalid(String s,int index,int open){
    //     if(open<0) return false;
    //     if(index==s.length()) return open==0;
    //     char c=s.charAt(index);
    //     if(c=='('){
    //         return isvalid(s, index+1, open+1);
    //     }
    //     else if(c==')'){
    //         return isvalid(s, index+1, open-1);
    //     }
    //     else{
    //         return isvalid(s, index+1, open) || 
    //         isvalid(s, index+1, open+1) || 
    //         isvalid(s, index+1, open-1);
    //     }
    // }

    //OPTIMAL

     public static boolean isvalid(String s){
        int minopen=0; // using this both var for range
        int maxopen=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){ //if char is ( then increase both minopen and maxopen
                minopen++;
                maxopen++;
            }
            else if(c==')'){ //if char is ) then decrease both minopen and maxopen
                minopen--;
                maxopen--;
            }
            else{ // if char is * it can (,)," "
                minopen--; //if * is ')'
                maxopen++; // if * is '('
            }
            if(maxopen<0) return false; // If maxOpen becomes negative, too many closing brackets : invalid string
            if(minopen<0) minopen=0;  // minOpen can't go below 0, as we can't have negative unmatched '('
        }
        return minopen==0;   // If minOpen is 0 at the end, it's a valid configuration
     } 

   public static void main(String[] args) {
       String s="(*))(";
       System.out.println(isvalid(s));
   }   
}
