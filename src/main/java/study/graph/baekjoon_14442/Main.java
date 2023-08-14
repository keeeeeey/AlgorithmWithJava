package study.graph.baekjoon_14442;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] check = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = row.charAt(j) - '0';
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        check[0][0] = 0;
        System.out.println(solution(N, M, K, arr, check));
    }

    private static int solution(int N, int M, int K, int[][] arr, int[][] check) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] > now.wall) {
                    if (arr[nx][ny] == 0) {
                        check[nx][ny] = now.wall;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall));
                    } else {
                        if (now.wall < K) {
                            check[nx][ny] = now.wall + 1;
                            q.offer(new Node(nx, ny, now.dist + 1, now.wall + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
