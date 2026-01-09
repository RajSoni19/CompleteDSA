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
public class Bottomview {
static class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

    

    public static List<Integer> bottom(BNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<Integer,Integer> mpp=new TreeMap<>(); //map that store vertical line,node
       // Queue<AbstractMap.SimpleEntry<BNode,Integer>> q=new LinkedList<>(); //Queue that store node,vertical line
        Queue<Pair<BNode,Integer>> q=new LinkedList<>();
        // q.add(new AbstractMap.SimpleEntry<>(root,0));
        q.add(new Pair<>(root,0));

        while(!q.isEmpty()){
        //    AbstractMap.SimpleEntry<BNode,Integer> entry=q.poll();
        Pair<BNode,Integer> entry=q.poll();
           BNode node=entry.getKey();
           int line=entry.getValue();
           
            mpp.put(line,node.data); //overwrite for bottom view 
           

           if(node.left!=null){
            // q.add(new AbstractMap.SimpleEntry<>(node.left,line-1));
            q.add(new Pair<>(node.left,line-1));
           }
           if(node.right!=null){
            // q.add(new AbstractMap.SimpleEntry<>(node.right,line+1));
            q.add(new Pair<>(node.right,line+1));
           }

        }

        // for(int val:mpp.values()){
        //     ans.add(val);

        // }
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        List<Integer> ans=new ArrayList<>();
        ans=bottom(root);
        System.out.println(ans);

    }
}
