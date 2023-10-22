package study.graph.baekjoon_14923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;
        int dist;
        int isBreak;

        public Node(int x, int y, int dist, int isBreak) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken());
        int Hy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken());
        int Ey = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, M, Hx, Hy, Ex, Ey, maze));
    }

    private static int solution(int n, int m, int hx, int hy, int ex, int ey, int[][] maze) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(hx, hy, 0, 0));
        int[][] dist = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[hx][hy] = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == ex && now.y == ey) {
                return now.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && dist[nx][ny] > now.isBreak) {
                    if (maze[nx][ny] == 1) {
                        if (now.isBreak == 0) {
                            dist[nx][ny] = dist[now.x][now.y] + 1;
                            q.offer(new Node(nx, ny, dist[now.x][now.y] + 1, now.isBreak + 1));
                        }
                    } else {
                        dist[nx][ny] = dist[now.x][now.y] + 1;
                        q.offer(new Node(nx, ny, dist[now.x][now.y] + 1, now.isBreak));
                    }
                }
            }
        }

        return -1;
    }
}
