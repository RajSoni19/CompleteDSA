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
public class LevelOrder {

    public static List<List<Integer>> level(BNode root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<BNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                BNode node=q.poll();
                level.add(node.data);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);

            }
        }
        ans.add(level);
        }
        return ans;

    }
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);

        List<List<Integer>> result=level(root);

        for(List<Integer> l:result){
            System.out.println(l);
        }
    }
}
