package baekjoonDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jelda {

    public static class Node {
        int cur_x;
        int cur_y;
        int acc;
        public Node(int cur_x, int cur_y, int acc) {
            this.cur_x = cur_x;
            this.cur_y = cur_y;
            this.acc = acc;
        }
    }

    public static StringTokenizer st;

    public static int N;

    public static int[][] arr;

    public static int[][] dist;

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    public static void solution() {
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = arr[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.acc - o2.acc;
            }
        });

        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.cur_x][now.cur_y] < now.acc) continue;

            for (int i = 0; i < 4; i++) {
                int nx = now.cur_x + dx[i];
                int ny = now.cur_y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int cost = dist[now.cur_x][now.cur_y] + arr[nx][ny];
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            cnt += 1;
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solution();

            System.out.println("Problem " + cnt + ": " + dist[N - 1][N - 1]);
        }

    }
}
