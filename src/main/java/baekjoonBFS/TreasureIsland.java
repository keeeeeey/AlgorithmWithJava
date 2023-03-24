package baekjoonBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureIsland {

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

    public static Character[][] arr;

    public static int N, M;

    public static int bfs(int x, int y) {

        int temp = 0;

        int[][] visited = new int[N][M];

        visited[x][y] = 1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 'L' && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    q.offer(new Node(nx, ny));
                    if (visited[nx][ny] > temp) {
                        temp = visited[nx][ny];
                    }
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Character[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    int minDist = bfs(i, j);
                    if (minDist > answer) {
                        answer = minDist;
                    }
                }
            }
        }

        System.out.println(answer - 1);
    }
}
