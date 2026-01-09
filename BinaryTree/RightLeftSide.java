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
public class RightLeftSide {

    public static void leftgo(BNode root,int level,List<Integer> res){
        if(root==null) return;
        if(level==res.size()){
            res.add(root.data);
            // return;
        }
        leftgo(root.left, level+1, res);
        leftgo(root.right, level+1, res);
    }


    public static List<Integer> leftside(BNode root){
      List<Integer> res=new ArrayList<>();
        leftgo(root,0,res);
        return res;
    }

    public static void rightgo(BNode root,int level,List<Integer> res){
        if(root==null) return;
        if(level==res.size()){
            res.add(root.data);
            // return;
        }
        rightgo(root.right, level+1, res);
        rightgo(root.left, level+1, res);

    }
    public static List<Integer> rightside(BNode root){
  List<Integer> res=new ArrayList<>();
        rightgo(root,0,res);
        return res;
    }

    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        List<Integer> lans=new ArrayList<>();
        lans=leftside(root);
        System.out.println(lans);
        List<Integer> rans=new ArrayList<>();
        rans=rightside(root);
        System.out.println(rans);


    }
}
