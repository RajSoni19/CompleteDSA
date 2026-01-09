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
public class BinaryTreefromInorderPreorder {

    public static BNode buildTree(int []preorder,int []inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
             map.put(inorder[i],i);  //store inorder node and index
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    public static BNode build(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend,Map<Integer,Integer> map){
        if(prestart>preend || instart>inend) return null;
        BNode root=new BNode(preorder[prestart]); //first node will always root in preorder
        int  inroot=map.get(root.data); //from map we can get inorder root
       int numsleft=inroot-instart; //number of nodes in left subtree
       root.left=build(preorder,prestart+1,prestart+numsleft,inorder,instart,inroot-1,map); //building left subtree
       root.right=build(preorder,prestart+numsleft+1,preend,inorder,inroot+1,inend,map); //building right subtree
       return root;
    }
    public static void levelorder(BNode root){
        if(root==null) return;
        levelorder(root.left);
        System.out.println(root.data);
        levelorder(root.right);
    }
    public static void main(String[] args) {
         int[] preorder={9,3,15,20,7};
         int[] inorder={3,9,20,15,7};
         BNode root=buildTree(preorder,inorder);
        levelorder(root);

    }
}
