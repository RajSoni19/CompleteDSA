package BinaryTree;
import java.util.*;
import javafx.util.Pair;
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
public class PrePostInOne {
 

    static class Pair<K, V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        K getKey(){
            return key;
        }
        V getValue(){
            return value;
        }
        void setValue(V value){
            this.value = value;
        }
    }

    public static List<List<Integer>> prepostInt(BNode root){
        List<Integer> pre=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        List<Integer> in=new ArrayList<>();

        if(root==null){
            return new ArrayList<>();
        }

        Stack<Pair<BNode,Integer>> st=new Stack<>();
        st.push(new Pair<>(root,1));

        while(!st.empty()){
            Pair<BNode,Integer> it=st.pop();
            if(it.getValue()==1){ //for preorder
                pre.add(it.getKey().data);
                it.setValue(2);
                st.push(it);

                if(it.getKey().left!=null){
                    st.push(new Pair<>(it.getKey().left,1));
                }
            }

            else if(it.getValue()==2){
                in.add(it.getKey().data); //for inorder
                it.setValue(3);
                st.push(it);

                if(it.getKey().right!=null){
                    st.push(new Pair<>(it.getKey().right,1));
                }
            }

            else{
                post.add(it.getKey().data); //for postorder
            }
        }
          


        List<List<Integer>> result=new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
        

                
    }
        




    
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        root.left.left=new BNode(4);
        root.left.right=new BNode(5);
        List<List<Integer>> finalans=prepostInt(root);
        List<Integer> pre=finalans.get(0);
        List<Integer> in=finalans.get(1);
        List<Integer> post=finalans.get(2);
        System.out.println(finalans);


    }
}
