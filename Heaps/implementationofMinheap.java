package Heaps;

class BinaryHeap{
    static int capacity;
    static int size;
    static int arr[];

     BinaryHeap(int cap) {
        capacity=cap;
        size=0;
        arr=new int[capacity];
    }

    static int parent(int i){ //for parent
        return (i-1)/2;
    }

    static int left(int i){ //left child
        return 2*i+1;
    }

    static int right(int i){ //right child
        return 2*i+2;
    }

    static void insert(int x){ //insert new key x
        if(size==capacity){
            System.out.println("Binaray heap overflow");
            return;
        }
        arr[size]=x;
        int k=size;
        size++;
        while(k!=0 && arr[parent(k)]> arr[k]){
            int temp=arr[parent(k)]; //swap
            arr[parent(k)]=arr[k];
            arr[k]=temp;
            k=parent(k);
        }
    }

    static void Heapify(int ind){
        int ri=right(ind);
        int li=left(ind);
        int smallest=ind;

        if(li<size && arr[li]< arr[smallest]){
            smallest=li;
        }
        if(ri<size && arr[ri]<arr[smallest]){
            smallest=ri;
        }
         // If the Minimum among the three nodes is not the parent itself,
    // then swap and call Heapify recursively
        if(smallest!=ind){
            int temp=arr[ind];
            arr[ind]=arr[smallest];
            arr[smallest]=temp;
            Heapify(smallest);
        }
    }

    static int getMin(){
        return arr[0];
    }

    static int ExtractMin(){ //remove and returns extract min. after removel to main mean heap property element is taken from last arr element and put on root then heapity property is use to main its property
        if(size<=0) return Integer.MAX_VALUE;
        if(size==1){
            size--;
            return arr[0];
        }
        int mini=arr[0];
        arr[0]=arr[size-1];
        size--;
        Heapify(0);
        return mini;
    }

    static void Decreasekey(int i,int val){ //update value of node at index i to a new smaller val then fix it
         arr[i]=val; //update value
         while(i!=0 && arr[parent(i)]>arr[i]){
           int temp=arr[parent(i)];
           arr[parent(i)]=arr[i];
           arr[i]=temp;
           i=parent(i);
        }
    }

    static void Delete(int i){ //given an index,delete value at that index from min-heap
        Decreasekey(i, Integer.MIN_VALUE);
        ExtractMin();
    }

    static void print(){
        for(int i=0;i<size;i++){
            System.out.println(arr[i]+ " ");
        }
        System.out.println();
    }




}
public class implementationofMinheap {

    public static void main(String[] args) {
        BinaryHeap h=new BinaryHeap(20);
        h.insert(4);
        h.insert(9);
        h.insert(1);
        h.print();

          h.ExtractMin();
    System.out.println("Min value is " + h.getMin());
    }
}
