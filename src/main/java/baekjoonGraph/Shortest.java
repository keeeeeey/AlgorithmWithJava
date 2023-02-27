package baekjoonGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Shortest {

    public static int V, E, K;
    public static int INF = Integer.MAX_VALUE;
    public static int[][] board;
    public static int[] dist;

    public static StringTokenizer st;

    public static void solution(int K) {
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
        }
        dist[K] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(K);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int j = 1; j <= V; j++) {
                if (board[now][j] != 0 && dist[now] + board[now][j] < dist[j]) {
                    queue.offer(j);
                    dist[j] = dist[now] + board[now][j];
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        board = new int[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            board[u][v] = w;
        }

        solution(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
