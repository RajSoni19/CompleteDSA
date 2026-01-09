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
public class SameTree {

    public static boolean issame(BNode root,BNode root2){
        if(root==null && root2==null){
            return true;
        }
        if(root==null || root2==null){
            return false;
        }
        return (root.data==root2.data)&&issame(root.left,root2.left)&&issame(root.right,root2.right);
        
    }
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        BNode root2=new BNode(1);
        root2.left=new BNode(2);
        root2.right=new BNode(3);
        System.out.println(issame(root, root2));
    }
}
