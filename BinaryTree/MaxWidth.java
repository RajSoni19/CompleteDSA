package BinaryTree;

import java.util.*;

public class BNode{

    int data;
    BNode left;
    BNode right;
    public BNode(int key){
        data=key;
        left=null;
        right=null;
    }
}
public class MaxWidth {

    public static int widhthofbt(BNode root){
        if(root==null) return 0;
        int maxwidth=0;
        Queue<AbstractMap.SimpleEntry<BNode,Integer>> q=new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int minindex=q.peek().getValue();
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                AbstractMap.SimpleEntry<BNode,Integer> p=q.poll();
                BNode node=p.getKey();
                int currindex=p.getValue()-minindex; //to make index (i-min)
                if(i==0) first=currindex;
                if(i==size-1) last=currindex;
                if(node.left!=null){
                    q.offer(new AbstractMap.SimpleEntry<>(node.left,2*currindex+1)); // after i-min then it left subnode we give index
                }
                if(node.right!=null){
                    q.offer(new AbstractMap.SimpleEntry<>(node.right,2*currindex+2));// after i-min then it rightsubnode we give index
                }
            }
            maxwidth=Math.max(maxwidth,last-first+1); //formule to find width last-first+1
        }
        return maxwidth;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        System.out.println(widhthofbt(root));

    }
}
