package Graph;
import java.util.*;

public class AlienDict {

    // Topological Sort using Kahn's Algorithm (BFS).
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return topo;
    }

    // Returns one valid order of characters.
    // K is inferred from unique characters present in dictionary.
    public static String findOrder(String[] dict, int N) {
        boolean[] present = new boolean[26];
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                present[word.charAt(i) - 'a'] = true;
            }
        }

        int K = 0;
        int[] map = new int[26];
        Arrays.fill(map, -1);
        List<Character> rev = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (present[c]) {
                map[c] = K;
                rev.add((char) (c + 'a'));
                K++;
            }
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[][] used = new boolean[K][K];

        // Build graph by comparing adjacent words in dictionary.
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    int u = map[s1.charAt(ptr) - 'a'];
                    int v = map[s2.charAt(ptr) - 'a'];
                    if (!used[u][v]) {
                        adj.get(u).add(v);
                        used[u][v] = true;
                    }
                    break;
                }
            }
        }

        // Perform topological sort.
        List<Integer> topo = topoSort(K, adj);
        if (topo.size() != K) {
            return "";
        }

        
        StringBuilder ans = new StringBuilder();
        for (int node : topo) {
            ans.append(rev.get(node));
        }
        return ans.toString();
    }

    // Overload when N is also not provided.
    public static String findOrder(String[] dict) {
        return findOrder(dict, dict.length);
    }

    // If order exists return "true", else return empty string "".
    public static String gfgStyleResult(String[] dict) {
        String order = findOrder(dict);
        return order.isEmpty() ? "" : "true";
    }

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(gfgStyleResult(dict));
        System.out.println(findOrder(dict));//this is actual problem to be solve
    }
}
