package study.priorityqueue.baekjoon_19598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Time[] arr = new Time[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Time(start, end);
        }

        Arrays.sort(arr, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                return t1.start - t2.start;
            }
        });

        PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.end - o2.end;
            }
        });
        pq.offer(arr[0]);

        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i].start < pq.peek().end) {
                answer += 1;
            } else {
                pq.poll();
            }
            pq.offer(arr[i]);
        }
        System.out.println(answer);
    }
}
