
import java.util.Comparator;
import java.util.PriorityQueue;

public class JCPriorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(11);
        pq.offer(12);
        pq.offer(13);
        pq.offer(14);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
        System.out.println(pq.peek());
    }
}
