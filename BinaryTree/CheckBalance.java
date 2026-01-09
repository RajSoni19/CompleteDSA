package BinaryTree;
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
public class CheckBalance {

    // public static boolean isbalance(BNode root){
    //     if(root==null){
    //         return true;
    //     }

    //     int lefth=getheight(root.left);
    //     int righth=getheight(root.right);
    //     if(Math.abs(lefth-righth)<=1 && isbalance(root.left) && isbalance(root.right) ){
    //         return true;
    //     }
    //     return false;
    // }

    // public static int getheight(BNode root){
    //        if(root==null){
    //         return 0;
    //        }

    //        int lefth=getheight(root.left);
    //        int righth=getheight(root.right);

    //        return Math.max(lefth,righth)+1;
    // }

    public static boolean balance(BNode root){
        return dfs(root)!=-1;
    }

    public static int dfs(BNode root){
        if(root==null) return 0;
        int lefth=dfs(root.left);
        if(lefth==-1) return -1;

        int righth=dfs(root.right);
        if(righth==-1) return -1;

        if(Math.abs(lefth-righth)>1){
            return -1;
        }

        return Math.max(lefth,righth)+1;

    }
    public static void main(String[] args) {
     BNode root=new BNode(1);
     root.left=new BNode(2);
     root.right=new BNode(3);   
    //  System.out.println(isbalance(root)); 
    System.out.println(balance(root));
    }
}
