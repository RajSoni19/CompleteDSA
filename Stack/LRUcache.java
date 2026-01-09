package Stack;

import java.util.HashMap;

class LRU{
    class Nodee{
        int key;
        int val;
        Nodee next;
        Nodee prev;
        Nodee(int key,int val){
            this.key=key;
        this.val=val;
        }
    }

    Nodee head=new Nodee(-1,-1);
    Nodee tail=new Nodee(-1,-1);

    int cap;
    HashMap<Integer,Nodee> map=new HashMap<>();
    public LRU(int capacity){
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }

    void addNode(Nodee newnode){
       Nodee temp=head.next;
       newnode.next=temp;
       newnode.prev=head;
       head.next=newnode;
       temp.prev=newnode;
    }

    void deleteNode(Nodee delnode){
        Nodee delprev=delnode.prev;
        Nodee delnext=delnode.next;
        delprev.next=delnext;
        delnext.prev=delprev;
    }

    public int get(int key){
        if(map.containsKey(key)){
             Nodee resnode=map.get(key);
             int res=resnode.val;

             map.remove(key);

             deleteNode(resnode);
             addNode(resnode);

             map.put(key,head.next);
             return res;
        }
        return -1;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
        Nodee exist=map.get(key);
        map.remove(key);
        deleteNode(exist);
        }
        if(map.size()==cap){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Nodee(key, value));
        map.put(key,head.next);
    }
}

public class LRUcache {
    public static void main(String[] args) {
        LRU cache=new LRU(4);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
    }
}
