package BinaryTree;

import java.util.Stack;

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

public class FlatterntoLL {

    static BNode prev = null;

    public static void bruteflatten(BNode root) {
        if (root == null)
            return;
        bruteflatten(root.right);
        bruteflatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void betterflatten(BNode root) {
        if (root == null)
            return;
        Stack<BNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            BNode curr = s.pop();
            if (curr.right != null)
                s.push(curr.right);
            if (curr.left != null)
                s.push(curr.left);
            if (!s.isEmpty())
                curr.right = s.peek();
            curr.left = null;
        }
    }

    public static void optimalmoris(BNode root) {
        BNode curr = root;
        while (curr != null) {
            // Check if the current
            // node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost
                // node in the left subtree
                BNode pre = curr.left;
                while (pre.right!= null) {
                    pre = pre.right;
                }

                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the
                // right child of the current node
                curr.right = curr.left;

                // Set the left child of
                // the current node to NULL
                curr.left = null;
            }

            // Move to the next node
            // on the right side
            curr = curr.right;
        }
    }

    public static void printflat(BNode root) {
        if (root == null)
            return;
        System.out.println(root.data);
        printflat(root.right);
    }

    public static void main(String[] args) {
        BNode root = new BNode(0);
        root.left = new BNode(1);
        root.right = new BNode(2);
        optimalmoris(root);
        printflat(root);

    }
}
