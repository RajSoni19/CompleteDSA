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
public class deleteBST {

    public static BNode deletenode(BNode root,int key){
       if(root==null){
            return null;
       }
       if(root.data==key){
        return helper(root);
       }
       BNode node=root;
       while(root!=null){
        if(root.data>key){
            if(root.left!=null && root.left.data==key){
                root.left=helper(root.left);
                break;
            }else{
                root=root.left;
            }
        }else{
            if(root.right!=null && root.right.data==key){
                root.right=helper(root.right);
                break;
            }else{
                root=root.right;
            }
        }
       }
       return node;
    }

    public static BNode helper(BNode root){ //connecting left's side last right to rightchild of key
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }

        BNode rightchild=root.right;
        BNode lastright=findlastright(root.left);
        lastright.right=rightchild;
        return root.left;
    }

    public static BNode findlastright(BNode root){
        if(root.right==null){
            return root;
        }
        return findlastright(root.right);
    }


    public static void main(String[] args) {
         BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        BNode node=deletenode(root,2);
        System.out.println(node.data);
    }
}
