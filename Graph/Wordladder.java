package Graph;

// import java.util.Arrays;
import java.util.*;
// import java.util.List;

public class Wordladder {

    /**
     * Word Ladder Problem: Find the shortest transformation sequence from startWord to targetWord
     * Rules: 1) Only one letter can be changed at a time
     *        2) Each transformed word must exist in the word list
     * Algorithm: BFS (Breadth-First Search) - guarantees shortest path
     * Time Complexity: O(N * M * 26) where N = word list size, M = word length
     * Space Complexity: O(N)
     */
    public static int wordLadderLength(String startWord,String targetWord,List<String> wordlist){
          // Queue to perform BFS: stores (current word, steps taken to reach it)
          Queue<Pair<String,Integer>> q=new LinkedList<>();
         // Start with the startWord at step 1
         q.add(new Pair<>(startWord,1));
         // HashSet for O(1) lookup and removal - stores all available words
         Set<String> st=new HashSet<>(wordlist);
         // Remove startWord to avoid revisiting it
         st.remove(startWord);
         // BFS: Process each word level by level
         while(!q.isEmpty()){
            // Get the current word and steps from queue front
            String word=q.peek().getKey();
            int steps=q.peek().getValue();
            q.poll();
            // If we reached the target word, return the number of steps
            if(word.equals(targetWord)) return steps;

            // Try changing each character position in the current word
            for(int i=0;i<word.length();i++){
                // Convert word to char array to modify individual characters
                char[] arr=word.toCharArray();
                // Save the original character at position i
                char original=arr[i];
                // Try replacing with every letter from 'a' to 'z'
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch; // Replace character at position i
                    String newword=new String(arr); // Create new word
                    // If this transformed word exists in the word list
                    if(st.contains(newword)){
                        st.remove(newword); // Remove to mark as visited (avoid cycles)
                        q.add(new Pair<>(newword,steps+1)); // Add to queue with incremented steps
                    }
                }
                // Restore original character for next iteration
                arr[i]=original;
            }
    
            
        }

        // If target word is not reachable, return 0
        return 0;
    
    }
   
   // Helper class to store key-value pairs (word, steps)
   static  class Pair<K,V>{
         private K key;
        private V value;
        public Pair(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){return key; }
        public V getValue(){return value; }

    }
    
    public static void main(String[] args) {
        // Test case: Transform "der" -> "dfs"
        // Possible path: der -> dfr -> dfs (2 transformations, so answer = 3 steps)
        List<String> wordList = Arrays.asList("des", "der", "dfr", "dgt", "dfs");
        String startWord = "der", targetWord = "dfs";

        // Print the minimum number of steps needed for transformation
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }
}
