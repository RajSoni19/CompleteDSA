package Stack;
import java.util.*;

public class InfixtoPostfix {

    static int Prec(char ch){
        switch(ch){
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp){
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (stack.isEmpty()) return "Invalid Expression"; // unmatched ')'
                stack.pop(); // pop '('
            } else { // operator
                while (!stack.isEmpty() && (Prec(stack.peek()) > Prec(c) ||
                       (Prec(stack.peek()) == Prec(c) && c != '^'))) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Postfix expression: " + infixToPostfix(exp));
    }
}
