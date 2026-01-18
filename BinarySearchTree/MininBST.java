package BinarySearchTree;
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
public class MininBST {

    public static int getmin(BNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root.data;
    }

    public static void main(String[] args) {
       BNode root = new BNode(6);
    root.left = new BNode(4);
    root.right = new BNode(7);
    root.left.left = new BNode(2);
    root.left.right = new BNode(5);
        System.out.println(getmin(root));
    }
}
