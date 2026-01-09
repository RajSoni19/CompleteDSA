package BinaryTree;
import java.util.*;

public class BNode{

    int data;
    BNode left;
    BNode right;
    public BNode(int key){
        data=key;
        left=null;
        right=null;
    }
}
public class ChildrenSum {
    public static void inorder(BNode root){
        if(root==null) return ;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void ChildrenSum(BNode root){
        if(root==null) return;         // Base case: If the current node
        // is null, return and do nothing.
        int child=0;
         // Calculate the sum of the values of
        // the left and right children, if they exist.
        if(root.left!=null) child+=root.left.data;
        if(root.right!=null) child+=root.right.data;

        // Compare the sum of children with
        // the current node's value and update
        if(child>=root.data) {
            root.data=child;
        }
        else{
            // If the sum is smaller, update the
            // child with the current node's value.
         if(root.left!=null){
            root.left.data=root.data;
         }else if(root.right!=null){
            root.right.data=root.data;
         }
        }

        // Recursively call the function
        // on the left and right children.

        ChildrenSum(root.left);
        ChildrenSum(root.right);

        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int total=0;
        if(root.left!=null){
            total+=root.left.data;
        }
        if(root.right!=null){
            total+=root.right.data;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if(root.left!=null || root.right!=null){
            root.data=total;
        }

    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        ChildrenSum(root);
        inorder(root);

    }
}
