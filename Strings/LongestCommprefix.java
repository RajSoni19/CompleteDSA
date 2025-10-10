package Strings;

public class LongestCommprefix {

    // Function to find the longest common prefix among an array of strings
    public static String LongestCommonPrefix(String strs[]){
        // If the array is null or empty, return an empty string
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0]; // Initialize prefix as the first string
        // Loop through the rest of the strings
        for(int i = 1; i < strs.length; i++){
            // While the current string does not start with the prefix
            while(!strs[i].startsWith(prefix)){
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, there is no common prefix
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix; // Return the longest common prefix found
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"}; // Input array of strings
        System.out.println(LongestCommonPrefix(strs)); // Output the longest common prefix
    }
    
}