package study.stack.baekjoon_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static class Top {
        int height;
        int idx;

        public Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.push(new Top(top, i + 1));
                    break;
                }

                if (stack.peek().height <= top) {
                    stack.pop();
                } else {
                    sb.append(stack.peek().idx).append(" ");
                    stack.push(new Top(top, i + 1));
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
