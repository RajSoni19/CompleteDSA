package BinarySearchTree;

public class LCAbst {

    public static BNode getlca(BNode root,BNode p,BNode q){
        if(root==null) return null;
        int curr=root.data;

          // both nodes lie in right subtree
        if(curr<p.data&&curr<q.data){
          return getlca(root.right, p, q);
        }

          // both nodes lie in left subtree
        if(curr>p.data&&curr>q.data){
            return getlca(root.left, p, q);
        }

        // split happens here (this is LCA)
        return root;

    }
    public static void main(String[] args) {
         BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        BNode node=getlca(root,root.left,root.right);
        System.out.println(node.data);
    }
}
