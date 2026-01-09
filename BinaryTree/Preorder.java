
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
public class Preorder {

    public static void preorder(BNode root,ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        ans.add(root.data);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }

    public static ArrayList<Integer> PreTraverse(BNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        preorder(root,ans);

        return ans;

    }

    public static ArrayList<Integer> PreIterate(BNode root){
          ArrayList<Integer> ans=new ArrayList<>();
          if(root==null){
            return ans;
          }

          Stack<BNode> s=new Stack<>();
          s.push(root);
          while(!s.isEmpty()){
            root=s.pop();
            ans.add(root.data);

            if(root.right!=null){
                s.add(root.right);
            }

            if(root.left!=null){
                s.add(root.left);
            }

          }
          return ans;

    }

    
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
          root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        ArrayList<Integer> ans=new ArrayList<>();
        ans=PreIterate(root);
        for(int val:ans){
            System.out.println(val);
        }



        
    }
}
