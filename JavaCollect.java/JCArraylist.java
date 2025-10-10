
import java.util.ArrayList;
import java.util.Iterator;

class JCArraylist{
    public static void main(String[] args) {
        ArrayList<Integer> students=new ArrayList<>();
        students.add(1);
        students.add(2);
        students.add(3);
        students.add(4);
        students.add(1,3);
        System.out.println(students);

        //Adding elements to new list from existing one
        ArrayList<Integer> l=new ArrayList<>();
        l.addAll(students);
        System.out.println(l);
        
        System.out.println(students.get(1));

        students.remove(0);
        students.remove(Integer.valueOf(4));
        students.set(0, 1);
        System.out.println(students);

        //Three Ways to Iterate to List -- For loop,Foreach Loop,Iterator
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }

        for(Integer ele:students){
            System.out.println(ele);
        }

        Iterator<Integer> it=students.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}