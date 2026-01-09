package Stack;
import java.util.*;

public class InfixtoPrefix {

    static boolean isAlpha(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    static boolean isDigit(char c){
        return (c >= '0' && c <= '9');
    }

    static boolean isOperand(char c){
        return isAlpha(c) || isDigit(c);
    }

    static int getPriority(char c){
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return 0;
    }

    // infix -> postfix for a given char[] (expects parentheses already adjusted if used for prefix conversion)
    static String infixToPostfix(char[] infixArr){
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infixArr) {
            if (isOperand(ch)) {
                output.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (stack.isEmpty()) return "Invalid Expression"; // unmatched ')'
                stack.pop(); // pop '('
            } else { // operator
                // pop while top has higher precedence OR same precedence and current is left-associative
                while (!stack.isEmpty() && stack.peek() != '(' &&
                       (getPriority(stack.peek()) > getPriority(ch) ||
                        (getPriority(stack.peek()) == getPriority(ch) && ch != '^'))) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            output.append(stack.pop());
        }

        return output.toString();
    }

    // convert infix char[] to prefix using reverse -> postfix -> reverse method
    static String infixToPrefix(char[] infix){
        int l = infix.length;
        // reverse infix and swap parentheses
        StringBuilder rev = new StringBuilder();
        for (int i = l - 1; i >= 0; i--) {
            char c = infix[i];
            if (c == '(') rev.append(')');
            else if (c == ')') rev.append('(');
            else rev.append(c);
        }

        String postfix = infixToPostfix(rev.toString().toCharArray());
        if (postfix.equals("Invalid Expression")) return postfix;

        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "(p+q)*(c-d)";
        System.out.println("Infix expression: " + s);
        System.out.println("Prefix expression: " + infixToPrefix(s.toCharArray()));
    }
}
