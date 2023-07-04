package study.dp.baekjoon_1823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.addLast(Integer.parseInt(br.readLine()));
        }
        System.out.println(solution(N));
    }

    private static int solution(int N) {
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (deque.peekFirst() < deque.peekLast()) {
                answer += deque.pollFirst() * i;
            } else {
                answer += deque.pollLast() * i;
            }
        }

        return answer;
    }
}
