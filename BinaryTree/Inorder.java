
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
public class Inorder {

    public static void Inorder(BNode root,ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        Inorder(root.left,ans);
        ans.add(root.data);
        Inorder(root.right,ans);
    }

    public static ArrayList<Integer> InorderIterate(BNode root){
        Stack<BNode> s=new Stack<>();
        BNode node=root;
        ArrayList<Integer> ans=new ArrayList<>();
        while(true){
            if(node!=null){
                s.add(node);
                node=node.left;
            }else{
                if(s.isEmpty()){
                    break;
                }
                node=s.pop();
                ans.add(node.data);
                node=node.right;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> InTraverse(BNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        Inorder(root,ans);

        return ans;

    }

    
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
          root.right = new BNode(3);
       
        ArrayList<Integer> ans=new ArrayList<>();
        ans=InorderIterate(root);
        for(int val:ans){
            System.out.println(val);
        }



        
    }
}
