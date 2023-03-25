package baekjoonString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringBomb {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (Character c : s1.toCharArray()) {
            stack.add(c);
            if (stack.size() >= s2.length()) {
                boolean flag = true;
                for (int i = 0; i < s2.length(); i++) {

                    if (!stack.get(stack.size() - s2.length() + i).equals(s2.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 0; i < s2.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i));
            }
        }
    }
}
