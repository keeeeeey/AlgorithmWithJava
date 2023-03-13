package baekjoonBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato3 {

    public static class Point {
        int z;
        int x;
        int y;
        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static StringTokenizer st;

    public static int M, N, H;

    public static int[][][] arr;

    public static int[] dx = {1, -1, 0, 0, 0, 0};

    public static int[] dy = {0, 0, 1, -1, 0, 0};

    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        q.offer(new Point(i, j, k));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point point = q.poll();

            int x = point.x;
            int y = point.y;
            int z = point.z;

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H && arr[nz][nx][ny] == 0) {
                    arr[nz][nx][ny] = arr[z][x][y] + 1;
                    q.offer(new Point(nz, nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        boolean flag = true;

        int answer = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        flag = false;
                        break;
                    }

                    if (arr[i][j][k] > answer) {
                        answer = arr[i][j][k];
                    }
                }
                if (!flag) break;
            }
            if (!flag) break;
        }

        if (flag) {
            System.out.println(answer - 1);
        } else {
            System.out.println(-1);
        }

    }
}
