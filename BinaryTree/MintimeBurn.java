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
public class MintimeBurn {

    public static void buildg(BNode root,  Map<BNode,BNode> parentmap){
         Queue<BNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BNode node=q.poll();

            // If left child exists
            if(node.left!=null){
                 // Store parent of left child
                parentmap.put(node.left, node);
                // Add left child to queue
                q.offer(node.left);
            }
            if(node.right!=null){
                parentmap.put(node.right,node);
                q.offer(node.right);
            }
        }
    }

    public static int mintime(BNode root,BNode target){
    Map<BNode,BNode> parentmap=new HashMap<>();
        buildg(root,parentmap);
        Set<BNode> visited=new HashSet<>();
        Queue<BNode> q=new LinkedList<>();
        q.offer(target);
        visited.add(target);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean burn=false;
            for(int i=0;i<size;i++){
                 BNode node=q.poll();

                        // Explore left child
                        if(node.left!=null && !visited.contains(node.left)){
                                visited.add(node.left);
                                q.offer(node.left);
                                burn=true;
                        }
                         
                        //explore right child
                        if(node.right!=null && !visited.contains(node.right)){
                            visited.add(node.right);
                            q.offer(node.right);
                            burn=true;
                        }

                        // Explore parent from map
                        if(parentmap.containsKey(node)&&!visited.contains(parentmap.get(node))){
                            visited.add(parentmap.get(node));
                            q.offer(parentmap.get(node));
                            burn=true;
                        }
            }
            if(burn){
                time++;
            }
        }
        return time;
    }
    public static void main(String[] args) {
        BNode root=new BNode(0);
        root.left=new BNode(1);
        root.right=new BNode(2);
        BNode target=root;
        System.out.println(mintime(root,target));
    }
}
