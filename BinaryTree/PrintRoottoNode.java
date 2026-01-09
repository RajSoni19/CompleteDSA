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
public class PrintRoottoNode {

    public static boolean getpath(BNode root,List<Integer> arr,int target){
        if(root==null) return false;
        arr.add(root.data);
        if(root.data==target) return true;
        if(getpath(root.left, arr, target)||getpath(root.right, arr, target)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }

    public static List<Integer> getsolve(BNode root,int target){
        List<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        getpath(root,arr,target);
        return arr;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        root.right.left=new BNode(3);
        int target=3;
        List<Integer> path=getsolve(root,target);
        System.out.println(path);

    }
}
