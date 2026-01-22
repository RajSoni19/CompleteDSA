package BinarySearchTree;

public class RecoverBST {
    BNode first;
    BNode prev;
    BNode middle;
    BNode last;

    public void inorder(BNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null&&(root.data<prev.data)){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        inorder(root.right);
    }

    public void recoverbst(BNode root){
     first=middle=last=null;
     prev=new BNode(Integer.MIN_VALUE);
     inorder(root);
     if(first!=null&&last!=null){ //if first case(Swapped nodes are not adjusted)
        int t=first.data;
        first.data=last.data;
        last.data=t;
     }else if(first!=null&&middle!=null){ //if second case(swapped nodes are adjusted)
           int t=first.data;
           first.data=middle.data;
           middle.data=t;
     }    
    }
    public static void main(String[] args) {
          BNode root = new BNode(5);
        root.left = new BNode(3);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(4);
        root.right.right = new BNode(8);
    }
}
