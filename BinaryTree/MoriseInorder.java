package BinaryTree;
import java.util.*;
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
public class MoriseInorder {

    public static List<Integer> getinorder(BNode root){
      List<Integer> inorder=new ArrayList<>();
      BNode curr=root;
      while(curr!=null){
          // If the current node's
            // left child is NULL
        if(curr.left==null){ //case 1
              // Add the value of the current
                // node to the inorder list
            inorder.add(curr.data);
            //move to right
            curr=curr.right;
        }else{
             // If the left child is not NULL,
                // find the predecessor (rightmost node
                // in the left subtree)
            BNode prev=curr.left;
            while(prev.right!=null && prev.right!=curr){
                prev=prev.right;
            }
              // If the predecessor's right child
                // is NULL, establish a temporary link
                // and move to the left child
            if(prev.right==null){ //case 2
                prev.right=curr;
                curr=curr.left;
            }else{
                  // If the predecessor's right child
                    // is already linked, remove the link,
                    // add current node to inorder list,
                    // and move to the right child
                prev.right=null; //case 3
                inorder.add(curr.data);
                curr=curr.right;
            }
        }
      }
      return inorder;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        System.out.println(getinorder(root));

    }
}
