
import java.util.Stack;
public class Parentheses {

    // O(n) time | O(n) space 
    public static boolean validate(String lisp) {
        Stack<Character> parenStack = new Stack<Character>();
        for(int i = 0; i < lisp.length(); i++) {
            if(lisp.charAt(i) == '(') {
                parenStack.push(lisp.charAt(i));
            } else if(lisp.charAt(i) == ')') {
                if(parenStack.peek() == '(') {
                    parenStack.pop();
                } else {
                    return false; //
                }
            } else {
                continue;
            }
        }
        if(parenStack.empty()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String test = "((()(())))";
        boolean check = validate(test);
        System.out.println(check);
        
    }
}
