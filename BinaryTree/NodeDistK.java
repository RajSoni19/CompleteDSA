package BinaryTree;
import java.util.*;

import javax.swing.tree.TreeNode;
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
public class NodeDistK {
    public static List<Integer> distancek(BNode root,BNode target,int k){
        if(root==null) return new ArrayList<>();
        // STEP 1: Create a map to store parent of each node
        // key   -> child node
        // value -> parent node
        Map<BNode,BNode> parentmap=new HashMap<>(); 
        mapparent(root,parentmap);
        return bfsfromtarget(target,parentmap,k);
        
    }

    // Build parent references using BFS
    public static void mapparent(BNode root,Map<BNode,BNode> parentmap){
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

    public static List<Integer> bfsfromtarget(BNode target,Map<BNode,BNode> parentMap,int k){
        // Queue for BFS traversal
                Queue<BNode> q=new LinkedList<>();
                 // Set to keep track of visited nodes (avoid infinite loop)
                Set<BNode> visited=new HashSet<>();
                q.offer(target);
                visited.add(target);
                int curr=0;
                while(!q.isEmpty()){
                    int size=q.size();

                    // Stop traversal once we reach distance K
                    if(curr++==k) break;
                    for(int i=0;i<size;i++){
                        BNode node=q.poll();

                        // Explore left child
                        if(node.left!=null && !visited.contains(node.left)){
                                visited.add(node.left);
                                q.offer(node.left);
                        }
                         
                        //explore right child
                        if(node.right!=null && !visited.contains(node.right)){
                            visited.add(node.right);
                            q.offer(node.right);
                        }

                        // Explore parent from map
                        if(parentMap.containsKey(node)&&!visited.contains(parentMap.get(node))){
                            visited.add(parentMap.get(node));
                            q.offer(parentMap.get(node));
                        }
                    }
                }
                 // All nodes left in queue are exactly K distance from target
                List<Integer> result=new ArrayList<>();
                while(!q.isEmpty()){
                    result.add(q.poll().data);
                }
                return result;



    }
    public static void main(String[] args) {
         BNode root = new BNode(3);
        root.left = new BNode(5);
        root.right = new BNode(1);
        root.left.left = new BNode(6);
        root.left.right = new BNode(2);
        root.left.right.left = new BNode(7);
        root.left.right.right = new BNode(4);
        root.right.left = new BNode(0);
        root.right.right = new BNode(8);
        BNode target=root.left;
        int k=2;
        List<Integer> result=new ArrayList<>();
        result=distancek(root,target,k);
        System.out.println(result);


    }
}
