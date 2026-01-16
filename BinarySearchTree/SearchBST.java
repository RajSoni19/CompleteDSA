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
public class SearchBST {

    public static BNode searchans(BNode root,int val){
        // while(root!=null && root.data!=val){
        //     if(val<root.data){
        //         root=root.left;
        //     }
        //     else{
        //         root=root.right;
        //     }
        // }
        // return root;

        if(root==null) return null;
        if(root.data==val) return root;
        if(val<root.data) return searchans(root.left, val);
        else return searchans(root.right, val); 
    }
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        root.left.right=new BNode(4);
        BNode ans=searchans(root,3);
        System.out.println(ans.data);
    }
}
