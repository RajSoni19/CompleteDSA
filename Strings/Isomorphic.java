package Strings;

public class Isomorphic {

    // Function to check if two strings are isomorphic
    public static boolean isIsomorphic(String s, String t) {
        // If lengths are not equal, they can't be isomorphic
        if (s.length() != t.length()) {
            return false;
        }
        // HashMaps to store character mappings from s->t and t->s
        java.util.HashMap<Character, Character> st = new java.util.HashMap<>();
        java.util.HashMap<Character, Character> ts = new java.util.HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i); // Character from s
            char tt = t.charAt(i); // Character from t

            // Check mapping from s to t
            if (st.containsKey(ss)) {
                if (st.get(ss) != tt) {
                    return false; // Mismatch in mapping
                }
            } else {
                st.put(ss, tt); // Add mapping s->t
            }

            // Check mapping from t to s
            if (ts.containsKey(tt)) {
                if (ts.get(tt) != ss) {
                    return false; // Mismatch in mapping
                }
            } else {
                ts.put(tt, ss); // Add mapping t->s
            }
        }
        return true; // Strings are isomorphic
    }

    public static void main(String[] args) {
        String s = "egg"; // First input string
        String t = "adh"; // Second input string
        System.out.println(isIsomorphic(s, t)); // Output result
    }
}