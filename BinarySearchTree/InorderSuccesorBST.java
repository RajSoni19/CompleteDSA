package BinarySearchTree;

public class InorderSuccesorBST {

    public static BNode getsuccess(BNode root,BNode p){
        BNode succesor=null;
        while(root!=null){
            if(root.data>p.data){
                succesor=root; //possible succesor
                root=root.left; //try to find smaller one
            }else{
                root=root.right; //succesor might be on right
            }
        }
        return succesor;
    }
    public static void main(String[] args) {
          BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        BNode p=root.left;
        BNode succesor=getsuccess(root,p);
        System.out.println(succesor.data);
    }
}
