package Strings;

public class LargestOddnumber {

    // Function to return the largest odd number substring from the given string
    public static String Odd(String num){
        // Iterate from the end of the string towards the beginning
        for(int i = num.length() - 1; i >= 0; i--){
            // Check if the current character (digit) is odd
            if(num.charAt(i) % 2 != 0){
                // Return the substring from the start to this odd digit (inclusive)
                return num.substring(0, i + 1);
            }
        }
        // If no odd digit is found, return an empty string
        return "";
    }

    public static void main(String[] args) {
        String num = "52"; // Input string representing a number
        System.out.println(Odd(num)); // Output the largest odd number substring
    }
    
}