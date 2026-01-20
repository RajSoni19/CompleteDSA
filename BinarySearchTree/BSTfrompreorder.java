package BinarySearchTree;

public class BSTfrompreorder {

    public static BNode createbst(int a[]){
        return bst(a,Integer.MAX_VALUE,new int[]{0});
    }

    public static BNode bst(int a[],int bound,int []i){
          // base cases
        if(i[0]==a.length||a[i[0]]>bound) return null;
        BNode root=new BNode(a[i[0]++]);
         // left subtree: values < root.data
        root.left=bst(a,root.data,i);
        // right subtree: values < bound
        root.right=bst(a,bound,i);
        return root;
    }
    public static void main(String[] args) {
        //   BNode root = new BNode(6);
        // root.left = new BNode(4);
        // root.right = new BNode(7);
        // root.left.left = new BNode(2);
        // root.left.right = new BNode(5);
        int a[]={8,5,1,7,10,2};
        BNode node=createbst(a);
        System.out.println(node.data);
    }
}
