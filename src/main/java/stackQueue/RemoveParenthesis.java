package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParenthesis {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x != ')') {
                stack.push(x);
            } else {
                while (stack.pop() != '(');
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        RemoveParenthesis rp = new RemoveParenthesis();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(rp.solution(str));
    }
}
