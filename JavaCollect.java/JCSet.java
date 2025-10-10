import java.util.*;

public class JCSet {
    public static void main(String[] args) {
        Set<Integer> s=new TreeSet<>();

        s.add(1);
        s.add(23);
        s.add(13);
        s.add(46);
        s.add(5);
        System.out.println(s);
        s.remove(46);
        System.out.println(s);
        System.out.println(s.contains(51));
        System.out.println(s.isEmpty());
        System.out.println(s.size());

    }
}
