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
public class HeightTree {

    public static int maxDepth(BNode root){
        if(root==null){
            return 0;
        }
         Queue<BNode> q=new LinkedList<>();
         q.add(root);
         int level=0;
         while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                BNode front=q.poll();
                
                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
            }
            level++;
         }
         return level;

    }


    //recursive one
    public static int maxDepthDFS(BNode root){
    if(root==null){
        return 0;
    }
    
    int leftHeight = maxDepthDFS(root.left);
    int rightHeight = maxDepthDFS(root.right);
    
    return 1 + Math.max(leftHeight, rightHeight);
}
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        int ans=maxDepthDFS(root);
        System.out.println(ans);

        
    }
}
