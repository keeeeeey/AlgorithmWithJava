package study.greedy.baekjoon_15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long A = pq.poll();
            long B = pq.poll();
            pq.offer(A + B);
            pq.offer(A + B);
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
