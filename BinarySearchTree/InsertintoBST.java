package BinarySearchTree;
class BNode {
    int data;
    BNode left;
    BNode right;

    public BNode(int key) {
        data = key;
        left = null;
        right = null;
    }
}
public class InsertintoBST {

    public static BNode insert(BNode root,int val){
        BNode node=root;
        if(root==null){
            return new BNode(val);
        }
        while(node!=null){
            if(val<node.data){
                if(node.left==null){
                    node.left=new BNode(val);
                    break;
                }
                node=node.left;
            }else{
                if(node.right==null){
                    node.right=new BNode(val);
                    break;
                }
                node=node.right;
            }
        }
        return root;
    }
    public static void main(String[] args) {
         BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        BNode node=insert(root,2);
        System.out.println(node.data);
   
    }
}
