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

public class FloorBST {

    public static int findfloor(BNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                // If the key is found, assign it
                // as the flooring and return
                floor = root.data;
                return floor;
            }

            // If the key is greater than the current
            // node's value, move to the right subtree
            if (key > root.data) {

                // Update the floor with the current node's
                // value and move to the right subtree

                floor = root.data;
                root = root.right;
            } else {
                // If the key is smaller than the current
                // node's value, move to the left subtree
                root = root.left;
            }

        }
        return floor;
    }

    public static void main(String[] args) {
        BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        System.out.println(findfloor(root, 4));
    }
}
