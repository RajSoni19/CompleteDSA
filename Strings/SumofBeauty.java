package Strings;
public class SumofBeauty {

    // Function to calculate the sum of beauty of all substrings of the given string
    public static int beautySum(String s){
        int sum = 0; // Variable to store the total beauty sum

        // Iterate over all possible starting indices of substrings
        for(int i = 0; i < s.length(); i++){
            int[] count = new int[26]; // Array to count frequency of each character in the current substring

            // Iterate over all possible ending indices of substrings starting from i
            for(int j = i; j < s.length(); j++){
                count[s.charAt(j) - 'a']++; // Increment count for the current character

                int max = Integer.MIN_VALUE; // To store the maximum frequency in the current substring
                int min = Integer.MAX_VALUE; // To store the minimum frequency in the current substring

                // Find the max and min frequency among all characters present in the substring
                for(int k = 0; k < 26; k++){
                    if(count[k] > 0){
                        max = Math.max(max, count[k]);
                        min = Math.min(min, count[k]);
                    }
                }
                sum = sum + max - min; // Add the beauty (max - min) to the total sum
            }
        }
        return sum; // Return the total beauty sum
    }

    public static void main(String[] args) {
        String s = "aabcb"; // Example input string
        System.out.println(beautySum(s)); // Output the sum of beauty of all substrings
    }
}