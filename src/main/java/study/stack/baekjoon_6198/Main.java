package study.stack.baekjoon_6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
            answer += stack.size() - 1;
        }
        System.out.println(answer);
    }
}
