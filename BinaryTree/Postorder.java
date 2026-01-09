
package BinaryTree;
import com.sun.nio.sctp.Association;
import java.util.*;
import javax.swing.text.DefaultStyledDocument;
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
public class Postorder {

    public static void postorder(BNode root,ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.data);
    }

    public static ArrayList<Integer> PostTraverse(BNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        postorder(root,ans);

        return ans;

    }

    public static ArrayList<Integer> PostusingStack2(BNode root){
        ArrayList<Integer> postorder=new ArrayList<>();
        if(root==null){
            return postorder;
        }

        Stack<BNode> s1=new Stack<>(); //This one for holding nodes
        Stack<BNode> s2=new Stack<>(); //This one store ans postorder
        s1.push(root);
        while(!s1.isEmpty()){
            root=s1.pop();
             s2.push(root);

             if(root.left!=null){
                s1.push(root.left);
             }

             if(root.right!=null){
                s2.push(root.right);
             }
        }

        while(!s2.isEmpty()){
            postorder.add(s2.pop().data);
        }
        return postorder;
    } 

    public static ArrayList<Integer> PostUsing1stack(BNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<BNode> s=new Stack<>();
        
        while(!s.isEmpty()||root!=null){
            if(root!=null){
            s.push(root);
            root=root.left;
            }
            else{
                BNode temp=s.peek().right;
                if(temp==null){
                    temp=s.pop();
                    ans.add(temp.data);
                    while(!s.isEmpty()&&temp==s.peek().right){
                        temp=s.pop();
                        ans.add(temp.data);
                    }
                }else{
                    root=temp;
                }

            }
        }
        return ans;
    }

    
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
          root.right = new BNode(3);
        
        ArrayList<Integer> ans=new ArrayList<>();
        // ans=PostTraverse(root);
        ans=PostUsing1stack(root);
        for(int val:ans){
            System.out.println(val);
        }



        
    }
}
