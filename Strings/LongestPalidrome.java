package Strings;
public class LongestPalidrome {
    
    // Function to find the longest palindromic substring in a given string
    public static String lPalidrome(String s){

        // If the string is null or empty, return an empty string
        if(s == null || s.length() < 1) return "";

        int start = 0; // Start index of the longest palindrome found
        int end = 0;   // End index of the longest palindrome found

        // Iterate through each character in the string
        for(int i = 0; i < s.length(); i++){
            // Check for odd length palindrome centered at i
            int len1 = ExpandCenter(s, i, i);
            // Check for even length palindrome centered between i and i+1
            int len2 = ExpandCenter(s, i, i + 1);
            int len = Math.max(len1, len2); // Take the longer one

            // If the found palindrome is longer than the previous longest
            if(len > end - start){
                // Update start and end indices to the new palindrome
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center and return the length of palindrome
    public static int ExpandCenter(String s, int left, int right){
        // Expand as long as the characters at left and right are equal and within bounds
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // Return the length of the palindrome found
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad"; // Example input string
        System.out.println(lPalidrome(s)); // Output the longest palindromic substring
    }
}