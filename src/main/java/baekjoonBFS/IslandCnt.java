package baekjoonBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IslandCnt {

    public static class Point {
        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};

    public static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static StringTokenizer st;

    public static int answer, w, h;

    public static int[][] arr;

    public static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            answer = 0;

            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        answer += 1;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(answer);

        }
    }
}
