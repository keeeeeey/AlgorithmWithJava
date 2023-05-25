package baekjoonBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafetyZone {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, maxH;

    public static int[][] arr, visited;

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    private static void bfs(int i, int j, int h) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (q.size() > 0) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] > h && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static int getCnt(int h) {
        int cnt = 0;
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > h && visited[i][j] == 0) {
                    bfs(i, j, h);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static int Solution() {
        int answer = 0;

        for (int h = 0; h < maxH; h++) {
            answer = Math.max(answer, getCnt(h));
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > maxH) {
                    maxH = arr[i][j];
                }
            }
        }

        System.out.println(Solution());
    }
}
