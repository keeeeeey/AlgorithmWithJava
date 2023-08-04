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
        boolean breakWall;

        public Node(int x, int y, boolean breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
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
        int[][][] dist = new int[2][N][M];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false));
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                }
            }
        }
        return -1;
    }

}
