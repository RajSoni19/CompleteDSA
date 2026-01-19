package BinarySearchTree;

public class validBST {

    public static boolean checkbst(BNode root){
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean validate(BNode node,long mini,long maxi){
        if(node==null) return true;
        if(node.data<=mini || node.data>=maxi) return false;
        return validate(node.left, mini, node.data)&&validate(node.right,node.data,maxi);
    }
    public static void main(String[] args) {
         BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        System.out.println(checkbst(root));
    }
}
