package study.greedy.baekjoon_7983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Duty {
        int period;
        int limit;

        public Duty(int period, int limit) {
            this.period = period;
            this.limit = limit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Duty[] arr = new Duty[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Duty(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, new Comparator<Duty>() {
            @Override
            public int compare(Duty o1, Duty o2) {
                return o2.limit - o1.limit;
            }
        });

        int now = arr[0].limit - arr[0].period;
        for (int i = 1; i < N; i++) {
            if (arr[i].limit <= now) {
                now = arr[i].limit - arr[i].period;
            } else {
                now = now - arr[i].period;
            }
        }
        System.out.println(now);
    }
}
