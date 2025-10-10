
import java.util.LinkedList;
import java.util.Queue;

public class JCLLQueue {
    public static void main(String[] args) {
        Queue<Integer> Q=new LinkedList<>();
        Q.offer(1);
        Q.offer(2);
        Q.offer(3);
        System.out.println(Q);
        System.out.println(Q.poll());
        System.out.println(Q);
        System.out.println(Q.peek());
    }
}
