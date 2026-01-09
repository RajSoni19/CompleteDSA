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
public class CountNodes {

    public static int bruteusingiterative(BNode root){
        if(root==null){
            return 0;
        }
        int cnt=0;
        Queue<BNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BNode node=q.poll();
            cnt++;
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }
        return cnt;

    }

    public static int bruteusingrecursive(BNode root){
        if(root==null){
            return 0;
        }
        return 1+bruteusingrecursive(root.left)+bruteusingrecursive(root.right);

    }

    public static int getcount(BNode root){
        if(root==null){
            return 0;
        }
        int lefth=getleft(root);
        int rigthh=getright(root);

        if(lefth==rigthh){
            return (1<<lefth)-1;
        }
        return 1+getcount(root.left)+getcount(root.right);
    }

    public static int getleft(BNode root){
        int h=0;
        while(root!=null){
            h++;
            root=root.left;
        }
        return h;
    }

    public static int getright(BNode root){
        int h=0;
        while(root!=null){
            h++;
            root=root.right;
        }
        return h;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        System.out.println(getcount(root));
    }
}
