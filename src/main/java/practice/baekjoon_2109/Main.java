package practice.baekjoon_2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{d, p});
        }

        int answer = 0;
        int[] check = new int[10001];
        while (!pq.isEmpty()) {
            int[] l = pq.poll();
            for (int i = l[0]; i >= 1; i--) {
                if (check[i] == 0) {
                    check[i] = 1;
                    answer += l[1];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
