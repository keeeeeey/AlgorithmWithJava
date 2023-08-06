package study.greedy.baekjoon_11000;

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
        Time[] tt = new Time[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tt[i] = new Time(start, end);
        }

        Arrays.sort(tt, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                if (t1.start == t2.start) return t1.end - t2.end;
                return t1.start - t2.start;
            }
        });

        PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.end - o2.end;
            }
        });
        pq.offer(tt[0]);

        int answer = 1;
        for (int t = 1; t < N; t++) {
            if (tt[t].start < pq.peek().end) {
                answer += 1;
            } else {
                pq.poll();
            }
            pq.offer(tt[t]);
        }
        System.out.println(answer);
    }
}
