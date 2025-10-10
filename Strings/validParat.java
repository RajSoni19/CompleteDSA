package Strings;
public class validParat {

    // Function to process the string and print only the inner parentheses (removes outermost)
    public static void valid(String s){
        java.lang.StringBuilder sb = new java.lang.StringBuilder(); // StringBuilder to build the result
        int bal = 0; // Balance counter to track open parentheses
        for(char c : s.toCharArray()){
            if (c == '(') {
                if(bal > 0){
                    sb.append(c); // Append '(' only if it's not the outermost
                }
                bal++; // Increase balance for '('
            } else if (c == ')') {
                bal--; // Decrease balance for ')'
                if (bal > 0) {
                    sb.append(c); // Append ')' only if it's not the outermost
                }
            }
        }
        System.out.println(sb); // Print the processed string
    }

    public static void main(String[] args) {
        String s = "(()())(())"; // Input string
        valid(s); // Call the function to process and print the result
    }
}