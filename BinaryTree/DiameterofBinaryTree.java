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
public class DiameterofBinaryTree {

    int diameter=0;
     int getheight(BNode root){
        if(root==null) return 0;
        int lefth=getheight(root.left);
        int righth=getheight(root.right);
        
        diameter=Math.max(diameter,lefth+righth);

        return 1+Math.max(lefth,righth);


    }

    int getdiameter(BNode root){
            getheight(root);
            return diameter;
    }
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        DiameterofBinaryTree tree = new DiameterofBinaryTree();
        System.out.println(tree.getdiameter(root));
    }
}
