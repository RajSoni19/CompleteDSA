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
public class LCA {

    public static BNode getlca(BNode root,BNode p,BNode q){
        if(root==null || root==p ||root==q){
            return root;
        }
        BNode leftl=getlca(root.left, p, q); //Traverse left subtree
        BNode rightr=getlca(root.right, p, q); //Traverse right subtree
        if(leftl==null) return rightr; //left subtree contains nothing usefull so right subtree can either contain p,q or LCA
        if(rightr==null) return leftl;//right subtree contains nothing usefull so left subtree can either contain p,q or LCA
        return root;//Both side return non-null so this is lca
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        BNode p=root.left;
        BNode q=root.right;
        BNode ans=getlca(root,p,q);
        System.out.println(ans.data);
    }
}
