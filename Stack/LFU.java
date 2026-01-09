package Stack;
import java.util.*;
class Nodes{
    int key,value,cnt;
    Nodes next;
    Nodes prev;
    Nodes(int key,int value){
        this.key=key;
        this.value=value;
        cnt=1;
    }
}


class List{
    int size;
    Nodes head;
    Nodes tail;
    List(){
        head=new Nodes(0,0);
        tail=new Nodes(0,0);
        head.next=tail;
        tail.prev=head;
        size=0;
    }

    void addFront(Nodes node){
        Nodes temp=head.next;
        node.next=temp;
        node.prev=head;
        head.next=node;
        temp.prev=node;
        size++;
    }

    void removeNode(Nodes delnode){
        Nodes prevnode=delnode.prev;
        Nodes nextnode=delnode.next;
        prevnode.next=nextnode;
        nextnode.prev=prevnode;
        size--;
    }

}

class LFUcache{
    Map<Integer,Nodes> keynode;
    Map<Integer,List> freqlistmap;
    int maxsizecache;
    int minfreq;
    int currsize;

    public LFUcache(int capacity){
        maxsizecache=capacity;
        minfreq=0;
        currsize=0;
        keynode=new HashMap<>();
        freqlistmap=new HashMap<>();
    }

    void updatefreqlistmap(Nodes node){
        keynode.remove(node.key);
        freqlistmap.get(node.cnt).removeNode(node);
        if(node.cnt==minfreq&&freqlistmap.get(node.cnt).size==0){
            minfreq++;
        }

        List nexthigherfreqlist=new List();
        if(freqlistmap.containsKey(node.cnt+1)){
            nexthigherfreqlist=freqlistmap.get(node.cnt+1);
        }

        node.cnt+=1;

        nexthigherfreqlist.addFront(node);

        freqlistmap.put(node.cnt,nexthigherfreqlist);
        keynode.put(node.key,node);
    }

    public int get(int key){
        if(keynode.containsKey(key)){
            Nodes node=keynode.get(key);
            int val=node.value;
            updatefreqlistmap(node);
            return val;
        }
        return -1;
    }

    public void put(int key,int value){
        if(maxsizecache==0){
            return;
        }

        if(keynode.containsKey(key)){
            Nodes node=keynode.get(key);
            node.value=value;
            updatefreqlistmap(node);
        }else{
            if(currsize==maxsizecache){
                List list=freqlistmap.get(minfreq);
                keynode.remove(list.tail.prev.key);
                freqlistmap.get(minfreq).removeNode(list.tail.prev);
                currsize--;
            }
            currsize++;
            minfreq=1;
            List listfreq=new List();
            if(freqlistmap.containsKey(minfreq)){
                listfreq=freqlistmap.get(minfreq);
            }

            Nodes node=new Nodes(key, value);
            listfreq.addFront(node);
            keynode.put(key, node);
            freqlistmap.put(minfreq,listfreq);
        }

    }

}


public class LFU {
    public static void main(String[] args) {
        LFUcache s=new LFUcache(2);
        s.put(1,1);
        s.put(2,2);
        System.out.println(s.get(1));

    }
}
