package Graph;

import java.util.*;

public class CourseSchedule2 {

    public static int[] giveorder(int course,int need[][]){
        List<List<Integer>> adj=new ArrayList<>();
        int deg[]=new int[course];

        for(int i=0;i<course;i++){
            adj.add(new ArrayList<>());
        }
       
        for(int pre[]:need){
            int a=pre[0];
            int b=pre[1];
            adj.get(b).add(a);
            deg[a]++;
            }

            Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<course;i++){
            if(deg[i]==0){
                  q.add(i);
            }
        }
        int topo[]=new int[course];
         int idx=0;
        while(!q.isEmpty()){

            int node=q.poll();
            topo[idx++]=node;
            for(int n:adj.get(node)){
                deg[n]--;
                if(deg[n]==0){
                    q.add(n);
                }
            }
        }


        if(idx==course){
            return topo;
        }
        return new int[0];



    }
    public static void main(String[] args) {
         int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        
        int []ans=giveorder(numCourses, prerequisites);
        // System.out.println(giveorder(numCourses,prerequisites));
        System.out.println(Arrays.toString(ans));
    }
}
