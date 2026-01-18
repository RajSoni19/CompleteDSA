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
public class KthSmallest {


    //BRUTE 
    // public static void inordertraverse(BNode root,List<Integer> values){ //inorder traverse of BST will return always sorted array
    //     if(root!=null){
    //         inordertraverse(root.left, values);
    //         values.add(root.data);
    //         inordertraverse(root.right, values);
    //     }
    // }

    // public static int getksmall(BNode root,int k){
    //     List<Integer> values=new ArrayList<>();
    //     inordertraverse(root,values);
    //     int ksmall=values.get(k-1);
    //     return ksmall;
    // }


    //OPTIMAL
    static int ans;
    static int cnt;
    
    public static void inordertraverse(BNode root,int k){
           if(root==null) return;
           inordertraverse(root.left, k);
           cnt++;
           if(cnt==k){
            ans=root.data;
            return;
           }
           inordertraverse(root.right, k);
    }
    public static int getksmall(BNode root,int k){
        cnt=0;
        ans=0;
        inordertraverse(root, k);
        return ans;
    }
    public static void main(String[] args) {
      BNode root = new BNode(6);
        root.left = new BNode(4);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        System.out.println(getksmall(root,1));

    }
}
