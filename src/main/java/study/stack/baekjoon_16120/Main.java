package study.stack.baekjoon_16120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ppap = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ppap.length(); i++) {
            stack.push(ppap.charAt(i));
            if (stack.size() >= 4) {
                String temp = "";
                for (int j = 0; j < 4; j++) {
                    temp = stack.pop() + temp;
                }

                if (!temp.equals("PPAP")) {
                    for (int k = 0; k < 4; k++) {
                        stack.push(temp.charAt(k));
                    }
                } else {
                    stack.push('P');
                }
            }
        }

        if (stack.size() == 1 && stack.pop() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
