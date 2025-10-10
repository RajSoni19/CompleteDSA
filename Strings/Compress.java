package Strings;

public class Compress {

    // Function to compress a string by replacing consecutive repeating characters with the character followed by the count
    public static String compress(String str){
        String newStr = ""; // Initialize the compressed string
        for(int i = 0; i < str.length(); i++){
            Integer count = 1; // Initialize count for each character
            // Count consecutive repeating characters
            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                count++;
                i++; // Move to the next character
            }
            newStr += str.charAt(i); // Add the character to the result
            if(count > 1){
                newStr += count.toString(); // Add the count if greater than 1
            }
        }
        return newStr; // Return the compressed string
    }

    public static void main(String[] args) {
        String str = "aaabbcc"; // Input string
        System.out.println(compress(str)); // Output the compressed string
    }
    
}