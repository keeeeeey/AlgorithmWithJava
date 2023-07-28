package study.stack.baekjoon_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.add(c);
            boolean flag = true;
            if (stack.size() >= bomb.length()) {
                for (int i = 0; i < bomb.length(); i++) {
                    if (!stack.get(stack.size() - bomb.length() + i).equals(bomb.charAt(i))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i = 0; i < bomb.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println((sb.length() > 0) ? sb : "FRULA");
    }
}
