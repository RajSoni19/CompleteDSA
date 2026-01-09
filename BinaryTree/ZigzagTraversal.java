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
public class ZigzagTraversal {

    public static List<List<Integer>> zigzag(BNode root){
        List<List<Integer>> result=new ArrayList<>();

        if(root==null) return result;

        Queue<BNode> q=new LinkedList<>();
        q.offer(root);

        boolean ltor=true; //This is boolean if true then node left to right insert

        while(!q.isEmpty()){
            int size=q.size();
            Integer[] level=new Integer[size];
            for(int i=0;i<size;i++){
             BNode node=q.poll();
             int index=ltor?i:size-1-i; //This is decide node value from left to right(i) or right to left (size-i-1);

             level[index]=node.data;

             if(node.left!=null) q.offer(node.left);
             if(node.right!=null) q.offer(node.right);


            }
            ltor=!ltor;//This is boolean if true then node right to left insert
            result.add(Arrays.asList(level));
        }

        return result;


    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        root.left.left=new BNode(3);
        root.left.right=new BNode(4);
        System.out.println(zigzag(root));
    }
}
