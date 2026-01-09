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
public class SerializeDeserilize {

    public static BNode deserial(String data){ //convert string to original structure of tree
        if(data.isEmpty()) return null; //if string empty then return null;
        String[] values=data.split(","); //converting string to array
        BNode root=new BNode(Integer.parseInt(values[0])); //first element of array will root
        Queue<BNode> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty()&&i<values.length){
            BNode node=q.poll();
            if(!values[i].equals("null")){ // if value in not null then add to leftnode 
                BNode leftnode=new BNode(Integer.parseInt(values[i]));
                node.left=leftnode;
                q.offer(leftnode);//adding to it for further traversal
            }
            i++; //moving ahead for rigthnode 
               //similar for rightnode also
            if(!values[i].equals("null")){
              BNode rightnode=new BNode(Integer.parseInt(values[i]));
              node.right=rightnode;
              q.offer(rightnode);
            }
            i++;

        }
        return root;

    }

    public static String serial(BNode root){ //making string from root (level order)
        if(root==null) return "";
      Queue<BNode> q=new LinkedList<>();
      StringBuilder s=new StringBuilder();
      q.offer(root);
      while(!q.isEmpty()){
        BNode currnode=q.poll();
        if(currnode==null){
            s.append("null,"); //if node is null then simply put null word at that place
        }else{ //if node is value then add it to string
            s.append(currnode.data).append(",");
            q.offer(currnode.left);
            q.offer(currnode.right);
        }
      }
      return s.toString();
    }
    public static void main(String[] args) {
        BNode root=new BNode(1);
        root.left=new BNode(2);
        root.right=new BNode(3);
        System.out.println(serial(root));
    }
}
