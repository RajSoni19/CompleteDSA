

import java.util.ArrayDeque;

class JCArrayDeque{
    public static void main(String[] args) {
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        ad.offer(11);
        ad.offerFirst(1);
        ad.offerLast(22);
        ad.offer(33);
        System.out.println(ad);

    }
}