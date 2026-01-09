package BinaryTree;
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
public class MathPathsum {
    int maxsum=Integer.MIN_VALUE;
    int maxpathSum(BNode root){
        dfs(root);
        return maxsum;
    }

    int dfs(BNode root){
        if(root==null) return 0;
        int lefth=Math.max(0,dfs(root.left));
        int righth=Math.max(0,dfs(root.right));
        maxsum=Math.max(
          maxsum,
          lefth+righth+root.data
        );
        return Math.max(lefth,righth)+root.data;
    }


    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        MathPathsum s=new MathPathsum();
        System.out.println(s.maxpathSum(root));
        
    }
}
