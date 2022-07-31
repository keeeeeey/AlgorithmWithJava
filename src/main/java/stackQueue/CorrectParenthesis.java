package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParenthesis {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    return answer;
                } {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = "NO";
            return answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        CorrectParenthesis cp = new CorrectParenthesis();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(cp.solution(str));
    }
}
