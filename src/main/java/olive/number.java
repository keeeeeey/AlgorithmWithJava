package olive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class number {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < number.length(); i++) {
            if (stack.size() > 0 && stack.peek() != 0 && stack.size() == i + 1) {
                if (stack.peek() == number.charAt(i) - '0') {
                    continue;
                } else {
                    stack.pop();
                    answer += 1;
                }
            }

            answer += 1;
            if (number.charAt(i) - '0' == 0) {
                stack.add(0);
            } else {
                stack.add(number.charAt(i) - '0');
                stack.add(number.charAt(i) - '0' + 1);
            }

            if (i == number.length() - 1) {
                if (stack.peek() != number.charAt(i) - '0') {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
