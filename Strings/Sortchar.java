package Strings;

import java.lang.StringBuilder;
import java.util.*;

public class Sortchar {

    // Function to sort characters in a string by frequency in descending order
    public static void Sortfreq(String s){
        HashMap<Character,Integer> map = new HashMap<>(); // Map to store frequency of each character
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Count frequency of each character
        }

        // Create buckets where index represents frequency
        List<Character>[] bucket = new List[s.length() + 1];
        for(Character key : map.keySet()){
            int freq = map.get(key); // Get frequency of character
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>(); // Initialize list if not already
            }
            bucket[freq].add(key); // Add character to its frequency bucket
        }

        StringBuilder sb = new StringBuilder(); // To build the result string
        // Traverse buckets from high frequency to low
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char ch : bucket[i]){
                    for(int j = 0; j < map.get(ch); j++){
                        sb.append(ch); // Append character 'freq' times
                    }
                }
            }
        }
        System.out.println(sb.toString()); // Print the sorted string
    }

    public static void main(String[] args) {
        String s = "tree"; // Input string
        Sortfreq(s); // Call function to sort by frequency
    }
}