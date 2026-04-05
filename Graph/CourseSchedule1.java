package Graph;
import java.util.*;

public class CourseSchedule1 {

    public static boolean canfinish(int courses,int need[][]){
        List<List<Integer>> adj=new ArrayList<>();
        int[] indeg=new int[courses];
        for(int i=0;i<courses;i++){
            adj.add(new ArrayList<>());
        }

        for(int []pre:need){
            int a=pre[0],b=pre[1];
            adj.get(b).add(a);
            indeg[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<courses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++; // count number of proceed nodes\
            for(int n:adj.get(node)){
                indeg[n]--;
                if(indeg[n]==0){
                    q.offer(n);
                }
            }

        }
        return cnt==courses; // if cycle is there then return NO
    }

    
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canfinish(numCourses,prerequisites));
    }
}
