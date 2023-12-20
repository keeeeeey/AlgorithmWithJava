package practice.baekjoon_23559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A, Math.abs(A - B), i, 5000});
            pq.offer(new int[]{B, Math.abs(A - B), i, 1000});
        }

        int[] ch = new int[N];
        int answer = 0;
        while (N > 0 && !pq.isEmpty()) {
            int[] node = pq.poll();
            if (ch[node[2]] == 1) continue;
            if (node[3] == 1000) {
                answer += node[0];
                ch[node[2]] = 1;
                N -= 1;
                X -= 1000;
            } else {
                int temp = X - 5000;
                if (temp > 0 && temp / 1000 >= N - 1) {
                    answer += node[0];
                    ch[node[2]] = 1;
                    N -= 1;
                    X -= 5000;
                }
            }
        }

        System.out.println(answer);
    }
}
