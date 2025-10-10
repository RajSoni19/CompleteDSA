package Strings;
 
import java.util.*;
public class RomanInt {

    // Function to convert a Roman numeral string to its integer value
    public static void Roman(String s){
        Map<Character,Integer> roman = new HashMap<>(); // Map to store Roman numeral values
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0; // Variable to store the final integer value

        // Loop through each character in the string
        for(int i = 0; i < s.length(); i++){
            int current = roman.get(s.charAt(i)); // Get value of current Roman numeral
            // If the next numeral is larger, subtract current value (for cases like IV, IX, etc.)
            if(i + 1 < s.length() && roman.get(s.charAt(i + 1)) > current){
                result -= current;
            }
            else{
                result += current; // Otherwise, add current value
            }
        }
        System.out.println(result); // Print the final integer value
    }

    public static void main(String[] args) {
        String s = "LVIII"; // Example Roman numeral string
        Roman(s); // Call the function to convert and print the result
    }
}