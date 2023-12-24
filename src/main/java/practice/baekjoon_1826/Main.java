package practice.baekjoon_1826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{a, b});
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        while (P < L) {
            while (!pq.isEmpty() && pq.peek()[0] <= P) {
                fuels.offer(pq.poll()[1]);
            }

            if (fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }

            answer++;
            P += fuels.poll();
        }

        System.out.println(answer);
    }
}
