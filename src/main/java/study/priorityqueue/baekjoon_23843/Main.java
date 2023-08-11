package study.priorityqueue.baekjoon_23843;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        PriorityQueue<Integer> pq = new PriorityQueue<>(M, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int time = 0;
        int idx = M;

        for (int i = 0; i < M; i++) {
            if (i < N) {
                pq.offer(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            time += 1;
            while (!pq.isEmpty() && pq.peek() == time) {
                pq.poll();
            }

            if (pq.size() < M) {
                int nextIdx = idx + M - pq.size();
                for (int i = idx; i < nextIdx; i++) {
                    if (i < N) {
                        pq.offer(arr[i] + time);
                    }
                }
                idx = nextIdx;
            }
        }
        System.out.println(time);
    }
}
