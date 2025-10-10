
import java.util.HashMap;
import java.util.Map;

public class JCMap {
    public static void main(String[] args) {
        Map<String,Integer> num=new HashMap<>();
        num.put("One",1);
        num.put("Two",2);
        num.put("Three",3);

        // To add element unique
        // if(!num.containsKey("Two")){
        //     num.put("Two",22);
        // }

        // num.putIf("Two", 11);
          
        for(Map.Entry<String,Integer> e: num.entrySet()){
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());

        }

        System.out.println(num);

        for(String k:num.keySet()){
            System.out.println(k);
        }

        System.out.println(num.containsValue(2));
    }
}
