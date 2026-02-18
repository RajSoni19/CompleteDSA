package Graph;

import java.util.*;

/**
 * Word Ladder II - Find all shortest transformation sequences from start to target word.
 * Each step must change exactly one character and result in a valid word from the list.
 */
public class Wordladder2 {

    static HashMap<String,Integer> mpp=new HashMap<>();
    static List<List<String>> ans=new ArrayList<>();
    /**
     * Finds all shortest paths from startWord to targetWord.
     * Uses BFS to explore level by level, ensuring shortest paths.
     * 
     * @param startWord Starting word
     * @param targetWord Target word to reach
     * @param wordList List of valid words
     * @return List of all shortest transformation sequences
     */
    // public static List<List<String>> findseq(String startWord,String targetWord,List<String> wordList){
    //     // Convert wordList to Set for O(1) lookup
    //     Set<String> st=new HashSet<>(wordList);
    //     // Queue stores each path as a List<String>
    //     Queue<List<String>> q=new LinkedList<>();
    //     q.offer(new ArrayList<>(Arrays.asList(startWord)));

    //     // Track words used at current level to remove after level finishes
    //     // This prevents revisiting words in different level paths
    //     List<String> usedOnlevel=new ArrayList<>();
    //     usedOnlevel.add(startWord);
    //     int level=0;

    //     // Result: all shortest paths to target word
    //     List<List<String>> ans=new ArrayList<>();
    //     // BFS to find all shortest paths
    //     while(!q.isEmpty()){
    //         // Get current path
    //         List<String> vec=q.poll();
            
    //         // When we move to next level, remove all words used in previous level
    //         // This ensures we only find shortest paths (no revisiting at same/higher level)
    //         if(vec.size()>level){
    //             level++;
    //             for(String used:usedOnlevel){
    //                 st.remove(used);
    //             }
    //         }

    //         // Last word in current path
    //         String word=vec.get(vec.size()-1);

    //         // If we reached target word, add this path to answer
    //         // Only keep paths of same length (shortest paths)
    //         if(word.equals(targetWord)){
    //             if(ans.isEmpty()){
    //                 ans.add(new ArrayList<>(vec));
    //             }else if(ans.get(0).size()==vec.size()){
    //                 ans.add(new ArrayList<>(vec));
    //             }
    //         }

    //         // Try changing each character of current word
    //         char[] wordArr=word.toCharArray();
    //         for(int i=0;i<wordArr.length;i++){
    //             char original=wordArr[i];
    //             // Try replacing character at position i with 'a' to 'z'
    //             for(char c='a';c<='z';c++){
    //                 wordArr[i]=c;
    //                 String newWord=new String(wordArr);

    //                 // If newWord exists in wordList, add it to current path and explore
    //                 if(st.contains(newWord)){
    //                  vec.add(newWord);
    //                  q.offer(new ArrayList<>(vec));
    //                  usedOnlevel.add(newWord);
    //                  vec.remove(vec.size()-1);
    //                 }
    //             }
    //             // Restore original character
    //             wordArr[i]=original;
    //         }
    //     }
        
    //     // Return all shortest transformation sequences
    //     return ans;
    // }


    /**
     * OPTIMAL SOLUTION: BFS + DFS Hybrid Approach
     * Step 1: BFS finds shortest distances from startWord to all words
     * Step 2: DFS backtracks from targetWord to startWord using only words on shortest paths
     */

    /**
     * DFS to backtrack and find all paths from word to startWord.
     * Only follows words that are exactly 1 step closer to startWord.
     * 
     * @param word Current word being processed
     * @param startWord Target start word to reach
     * @param seq Current path being built (in reverse)
     */
    public static  void dfs(String word,String startWord,List<String> seq){
        // Base case: reached the start word, add complete path to answer
        if(word.equals(startWord)){
            // Copy sequence and reverse it (we built it backwards)
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        // Get the step count (distance) of current word from startWord
        int steps=mpp.get(word);
        
        // Try changing each character position
        for(int i=0;i<word.length();i++){
            char[] arr=word.toCharArray();
            // Try all 26 letters
            for(char ch='a';ch<='z';ch++){
                arr[i]=ch;
                String replaced=new String(arr);
                
                // Only proceed if:
                // 1. replaced word exists in HashMap
                // 2. replaced word is exactly 1 step CLOSER to startWord (step count is 1 less)
                // This ensures we only traverse shortest paths backwards
                if(mpp.containsKey(replaced)&&mpp.get(replaced)+1==steps){
                    seq.add(replaced);
                    dfs(replaced,startWord,seq);
                    seq.remove(seq.size()-1);  // Backtrack
                }
            }
        }
    }

    /**
     * Main function using BFS + DFS hybrid approach.
     * BFS Phase: Build shortest path distances from startWord
     * DFS Phase: Backtrack from targetWord to find all shortest paths
     */
    public static List<List<String>> findseq(String startWord,String targetWord,List<String> wordList){
        Set<String> st=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        
        // ===== BFS PHASE: Build distance map =====
        q.add(startWord);
        // Store step count for each word (startWord is at distance 1)
        mpp.put(startWord,1);
        int size=startWord.length();
        st.remove(startWord);

        // BFS to find shortest distances from startWord to all reachable words
        while(!q.isEmpty()){
            String word=q.poll();
            int steps=mpp.get(word);
            // Stop BFS once we reach target (optimization)
            if(word.equals(targetWord)) break;
            
            // Try changing each character position of current word
            for(int i=0;i<size;i++){
                char[] arr=word.toCharArray();
                // Try all 26 lowercase letters
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String replaced=new String(arr);
                    
                    // If replaced word exists in wordList and hasn't been visited
                    if(st.contains(replaced)){
                        q.add(replaced);              // Add to queue for further exploration
                        st.remove(replaced);          // Mark as visited
                        mpp.put(replaced,steps+1);    // Store distance from startWord
                    }
                }
            }
        }

        // If target word not reachable, return empty answer
        if(!mpp.containsKey(targetWord)) return ans;
        
        // ===== DFS PHASE: Find all shortest paths =====
        List<String> seq=new ArrayList<>();
        seq.add(targetWord);
        // DFS backtracks from target to start, using only words on shortest paths
        dfs(targetWord,startWord,seq);
        return ans;


    }
    
    public static void main(String[] args) {
         // Test case: find paths from "der" to "dfs"
         // Valid intermediate words: "des", "dfr", "dgt", "dfs"
         List<String> wordList = Arrays.asList("des", "der", "dfr", "dgt", "dfs");
        String startWord = "der", targetWord = "dfs";
        
        // Get all shortest transformation sequences
        List<List<String>> ans=findseq(startWord,targetWord,new ArrayList<>(wordList));
        
        // Print results
        System.out.println(ans);
    }
}
