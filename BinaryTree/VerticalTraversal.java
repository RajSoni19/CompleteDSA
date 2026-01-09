package BinaryTree;

import java.util.*;

class BNode{

    int data;
    BNode left;
    BNode right;
    public BNode(int key){
        data=key;
        left=null;
        right=null;
    }
}
public class VerticalTraversal {
    static class Pair {
        BNode node;
        int vertical;
        int level;

        Pair(BNode n, int v, int l) {
            node = n;
            vertical = v;
            level = l;
        }
    }
        public static List<List<Integer>> findVertical(BNode root){


        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> nodes=new TreeMap<>(); //for veritcal,level and node 
        Queue<Pair> todo=new LinkedList<>();
        todo.offer(new Pair(root,0,0));

        while(!todo.isEmpty()){
          Pair p=todo.poll();
          BNode temp=p.node;
          int x=p.vertical;
          int y=p.level;

          nodes.putIfAbsent(x, new TreeMap<>()); //Create column if missing
          nodes.get(x).putIfAbsent(y, new PriorityQueue<>()); //Create level if missing
          nodes.get(x).get(y).offer(temp.data); //Insert node value in sorted order

          if(temp.left!=null){
             todo.offer(new Pair(temp.left, x-1, y+1));
          } 
          if(temp.right!=null){
            todo.offer(new Pair(temp.right, x+1, y+1));
          }
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:nodes.values()){
            List<Integer> col=new ArrayList<>();
            for(PriorityQueue<Integer> pq:ys.values()){
                while(!pq.isEmpty()){
                    col.add(pq.poll());
                }
            }
            ans.add(col);
        }
        return ans;
    }

    

    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        List<List<Integer>> ans=findVertical(root);
        System.out.println(ans);
    }
}
