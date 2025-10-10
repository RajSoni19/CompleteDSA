
import java.util.Stack;

public class JCstack {
    public static void main(String[] args) {
        Stack<String> animal=new Stack<>();
        animal.push("Lion");
        animal.push("Fox");
        animal.push("Horse");
        System.out.println(animal.peek());
        animal.pop();
        System.out.println(animal.peek());
        System.out.println(animal);
    }
    
}
