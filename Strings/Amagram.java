package Strings;

public class Amagram {
    // Function to check if two strings are anagrams (case-insensitive)
    public static boolean Valid(String str1, String str2) {
        str1 = str1.toUpperCase(); // Convert first string to uppercase
        str2 = str2.toUpperCase(); // Convert second string to uppercase

        // If lengths are not equal, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26]; // Array to count occurrences of each letter

        // Count each character in the first string
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'A']++;
        }

        // Subtract the count for each character in the second string
        for (int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i) - 'A']--;
        }

        // If any count is not zero, the strings are not anagrams
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true; // Strings are anagrams
    }

    public static void main(String[] args) {
        String str1 = "INTEGER"; // First input string
        String str2 = "TEGERNI"; // Second input string
        System.out.println(Valid(str1, str2)); // Output whether the strings are anagrams
    }
}