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

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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
        int[][][] dist = new int[N][M][2];
        dist[0][0][0] = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (nx == N - 1 && ny == M - 1) {
                        answer = Math.min(answer, dist[now.x][now.y][0] + 1);
                        continue;
                    }

                    if (graph[nx][ny] == 0) {
                        if (dist[nx][ny][0] == 0) {
                            dist[nx][ny][0] = dist[now.x][now.y][0] + 1;
                            dist[nx][ny][1] = dist[now.x][now.y][1];
                            q.offer(new Node(nx, ny));
                        } else {
                            if (dist[nx][ny][0] > dist[now.x][now.y][0] + 1) {
                                dist[nx][ny][0] = dist[now.x][now.y][0] + 1;
                                dist[nx][ny][1] = dist[now.x][now.y][1];
                                q.offer(new Node(nx, ny));
                            }
                        }
                    } else {
                        if (dist[now.x][now.y][1] == 0) {
                            dist[nx][ny][0] = dist[now.x][now.y][0] + 1;
                            dist[nx][ny][1] = 1;
                            q.offer(new Node(nx, ny));
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
