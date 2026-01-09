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
public class BoundaryTravarsel {

    boolean isleaf(BNode root){
        return root.left==null&&root.right==null;
    }

    void addleft(BNode root,List<Integer> res){
        BNode curr=root.left;
        while(curr!=null){
            if(isleaf(curr)==false) res.add(curr.data);
            if(curr.left!=null){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
    }

    void addright(BNode root,List<Integer> res){
        BNode curr=root.right;
        List<Integer> s=new ArrayList<>();
        while(curr!=null){
            if(isleaf(curr)==false) s.add(curr.data);
            if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }

        for(int i=s.size()-1;i>=0;i--){
            res.add(s.get(i));
        }
    }

    void addleaf(BNode root,List<Integer> res){
        if(isleaf(root)){
            res.add(root.data);
            return;
        }

        if(root.left!=null){
            addleaf(root.left, res);
        }
        if(root.right!=null){
            addleaf(root.right, res);
        }
    }


    public  List<Integer> finalans(BNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }

        if(isleaf(root)==false){
            res.add(root.data);
        }
        addleft(root,res);
        addleaf(root, res);
        addright(root, res);

        return res;


    }
    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right.left = new BNode(6);
        root.right.right = new BNode(7);

        List<Integer> ans=new ArrayList<>();
        BoundaryTravarsel bt=new BoundaryTravarsel();
        ans=bt.finalans(root);
        System.out.println(ans);
    }
}
