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
public class BinaryTreefromInorderPostorder {

    public static BNode buildTree(int []postorder,int []inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
             map.put(inorder[i],i);  //store inorder node and index
        }
        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }

    public static BNode build(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend,Map<Integer,Integer> map){
        if(poststart>postend || instart>inend) return null;
        BNode root=new BNode(postorder[postend]); //last  node will always root in postorder
        int  inroot=map.get(root.data); //from map we can get inorder root
       int numsleft=inroot-instart; //number of nodes in left subtree
       root.left=build(postorder,poststart,poststart+numsleft-1,inorder,instart,inroot-1,map); //building left subtree
       root.right=build(postorder,poststart+numsleft,postend-1,inorder,inroot+1,inend,map); //building right subtree
       return root;
    }
    public static void levelorder(BNode root){
        if(root==null) return;
        levelorder(root.left);
        System.out.println(root.data);
        levelorder(root.right);
    }
    public static void main(String[] args) {
         int[] inorder   = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
         BNode root=buildTree(postorder,inorder);
        levelorder(root);

    }
}
