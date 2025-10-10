import java.util.*;


public class JCollectionFrame {
    public static void main(String[] args) {
            List<Integer> l=new ArrayList<>();
            l.add(22);
            l.add(2);
            l.add(72);
            l.add(2);
            l.add(52);
            // System.out.println(Collections.min(l));
            // System.out.println(Collections.max(l));
            // System.out.println(Collections.frequency(l, 2));
            Collections.sort(l,Comparator.reverseOrder());
            System.out.println(l);

    }
}
