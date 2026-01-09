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
public class Topview {

    public static List<Integer> top(BNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<Integer,Integer> mpp=new TreeMap<>(); //map that store vertical line,node
        Queue<AbstractMap.SimpleEntry<BNode,Integer>> q=new LinkedList<>(); //Queue that store node,vertical line
        q.add(new AbstractMap.SimpleEntry<>(root,0));
        while(!q.isEmpty()){
           AbstractMap.SimpleEntry<BNode,Integer> entry=q.poll();
           BNode node=entry.getKey();
           int line=entry.getValue();
           if(!mpp.containsKey(line)){
            mpp.put(line,node.data);
           }

           if(node.left!=null){
            q.add(new AbstractMap.SimpleEntry<>(node.left,line-1));
           }
           if(node.right!=null){
            q.add(new AbstractMap.SimpleEntry<>(node.right,line+1));
           }

        }

        for(int val:mpp.values()){
            ans.add(val);
        }
        return ans;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        List<Integer> ans=new ArrayList<>();
        ans=top(root);
        System.out.println(ans);

    }
}
