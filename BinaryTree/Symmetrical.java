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
public class Symmetrical {

    public static boolean isSymmetriccheck(BNode root1,BNode root2){
        if(root1==null||root2==null){
            return root1==root2;
        }
        return (root1.data==root2.data)&&isSymmetriccheck(root1.left,root2.right)&&isSymmetriccheck(root1.right, root2.left);
    }

    public static boolean isSymmetric(BNode root){
           if(root==null) return true;
           return isSymmetriccheck(root.left,root.right);
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        System.out.println(isSymmetric(root));
    }
}
