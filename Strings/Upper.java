package Strings;
public class Upper {
    public static String Upper(String s) {
        // Handle null or empty strings
        if (s == null || s.isEmpty()) {
            return s;
        }

        java.lang.StringBuilder sb = new java.lang.StringBuilder(" ");
        char ch = Character.toUpperCase(s.charAt(0)); 
        sb.append(ch);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && i < s.length() - 1) {
                sb.append(s.charAt(i)); // Append the space
                i++; // Move to the next character after the space
                sb.append(Character.toUpperCase(s.charAt(i))); // Capitalize the character after the space
            } else {
                sb.append(s.charAt(i)); // Append other characters as is
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "hello world";
        String s2 = "java programming language";
        String s3 = "singleword";
        String s4 = ""; // Empty string
        String s5 = null; // Null string

        System.out.println(Upper(s1)); // Output: Hello World
        System.out.println(Upper(s2)); // Output: Java Programming Language
        System.out.println(Upper(s3)); // Output: Singleword
        System.out.println(Upper(s4)); // Output: (empty string)
        System.out.println(Upper(s5)); // Output: null
    }
}
