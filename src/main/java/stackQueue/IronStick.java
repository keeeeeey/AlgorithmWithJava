package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        IronStick is = new IronStick();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(is.solution(str));
    }
}
