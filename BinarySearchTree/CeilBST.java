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
public class CeilBST {

    public static  int findceil(BNode root,int key){
        int ceil=-1;
        while(root!=null){
            if(root.data==key){
                  // If the key is found, assign it
            // as the ceiling and return
                ceil=root.data;
                return ceil;
            }
            if(key>root.data){
                
            // If the key is greater,
            // move to the right subtree
                root=root.right;
            }else{
                // If the key is smaller, update ceil
                // and move to the left subtree
                ceil=root.data;
                root=root.left;
            }

        }
        return ceil;
    }
    public static void main(String[] args) {
          BNode root = new BNode(6);
    root.left = new BNode(4);
    root.right = new BNode(7);
    root.left.left = new BNode(2);
    root.left.right = new BNode(5);
    System.out.println(findceil(root,4));
    }
}
