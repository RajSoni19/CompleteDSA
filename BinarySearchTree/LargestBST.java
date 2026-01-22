package BinarySearchTree;


 class Nodevalue{
  public  int maxnode,minnode,maxsize;
    Nodevalue(int minnode,int maxnode,int maxsize){
        this.minnode=minnode;
        this.maxnode=maxnode;
        this.maxsize=maxsize;
    }

}

public class LargestBST {

    public static Nodevalue helper(BNode root){

         // base case
         if(root==null){
        return new Nodevalue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
         }  


         //postorder            
         Nodevalue left=helper(root.left);
         Nodevalue right=helper(root.right);

         // if subtree is BST
         if(left.maxnode<root.data&&root.data<right.minnode){ //largest value in left side and smallest value in right side
            return new Nodevalue(Math.min(root.data,left.minnode), Math.max(root.data,right.maxnode), left.maxsize+right.maxsize+1);
         }


         // if not BST
         return new Nodevalue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxsize,right.maxsize));

    }



    public static int largesize(BNode root){
        return helper(root).maxsize;

    }
    public static void main(String[] args) {
        BNode root = new BNode(5);
        root.left = new BNode(3);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(4);
        root.right.right = new BNode(8);
        System.out.println(largesize(root));
    }
}
