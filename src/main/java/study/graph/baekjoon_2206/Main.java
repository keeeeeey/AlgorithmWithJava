package study.graph.baekjoon_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;
        int dist;
        int wall;

        public Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(bfs(N, M, graph));
    }

    private static int bfs(int N, int M, int[][] graph) {
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                answer = now.dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny] > now.wall) {
                    if (graph[nx][ny] == 0) {
                        dist[nx][ny] = now.wall;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall));
                    } else {
                        if (now.wall == 0) {
                            dist[nx][ny] = now.wall + 1;
                            q.offer(new Node(nx, ny, now.dist + 1, now.wall + 1));
                        }
                    }

                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }

}
