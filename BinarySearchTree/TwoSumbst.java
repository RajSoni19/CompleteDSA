package BinarySearchTree;

import java.util.*;

class BST {

    Stack<BNode> s;
    boolean reverse;

    BST(BNode root, boolean isReverse) {
        s = new Stack<>();
        reverse = isReverse;
        // Push nodes from one side into the stack
        pushAll(root);
    }

    // This function checks if there are still nodes to visit
    boolean hasNext() {
        return !s.isEmpty();
    }

    // This function returns the next node’s value in the chosen order
    int next() {
        BNode temp = s.pop();

        // If we are not in reverse mode, move to the right child(means back (desceding
        // order))
        if (!reverse) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }

        // Return the value of the node we just processed
        return temp.data;
    }

    // Helper function pushes nodes from current down to edge (left or right)
    void pushAll(BNode node) {
        // Keep going until node becomes null
        while (node != null) {
            s.push(node);
            // If reverse is true, move to right child means back
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

public class TwoSumbst {
    public static boolean findsum(BNode root, int k) {
        if (root == null)
            return false;

        // Create two iterators: one from smallest, one from largest

        BST l = new BST(root, false);
        BST r = new BST(root, true); // means back

        // Get the first values
        int i = l.next();
        int j = r.next();
        while (i < j) {
            // If sum is exactly k, return true
            if (i + j == k)
                return true;
            // If sum is smaller, move left iterator forward

            else if (i + j < k)
                i = l.next();
            // If sum is bigger, move right iterator backward
            else
                j = r.next();
        }
        return false;
    }

    public static void main(String[] args) {
        BNode root = new BNode(5);
        root.left = new BNode(3);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(4);
        root.right.right = new BNode(8);

        System.out.println(findsum(root, 8));
    }
}
