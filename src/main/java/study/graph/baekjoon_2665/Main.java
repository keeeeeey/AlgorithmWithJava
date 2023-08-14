package study.graph.baekjoon_2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(solution(N, arr));
    }

    private static int solution(int N, int[][] arr) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        int[][] check = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                check[i][j] = Integer.MAX_VALUE;
            }
        }
        check[0][0] = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                answer = Math.min(answer, now.wall);
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && check[nx][ny] > now.wall) {
                    if (arr[nx][ny] == 1) {
                        check[nx][ny] = now.wall;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall));
                    } else {
                        check[nx][ny] = now.wall + 1;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall + 1));
                    }
                }
            }
        }
        return answer;
    }
}
