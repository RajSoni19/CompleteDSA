package Stack;

class Queuew{
      int arr[];
     int start,end,currsize,maxsize;
      Queuew(){
        this.arr=new int[33];
        start=-1;
        end=-1;
        currsize=0;
      }

      Queuew(int maxsize){
        this.maxsize=maxsize;
        this.arr=new int[maxsize];
           start=-1;
        end=-1;
        currsize=0;
      }

      void push(int ele){
          if(currsize==maxsize){
            System.out.println("full");
            
          }
          if(end==-1){
            start=0;
            end=0;
          }else{
            end=(end+1)%maxsize;
          }
          arr[end]=ele;
          currsize++;
      }
      public int pop(){
        if(start==-1){
            System.out.println("Empty");
        }
        int pope=arr[start];
        if(currsize==1){
            start=-1;
            end=-1;
        }
        else{
        start=(start+1)%maxsize;
        }
        currsize--;
        return pope;
      }

      int top(){
        return arr[start];
      }

      int size(){
        return currsize;
      }
}

public class QueueusingArray {
    public static void main(String[] args) {
        Queuew q=new Queuew(6);
        q.push(3);
        q.push(5);
        q.pop();
        System.out.println(q.size());

    }
}
