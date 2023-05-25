package baekjoonBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Byuk {

    public static class Point {
        int x;
        int y;
        int z;
        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = 0;
        }
    }

    public static int N, M;

    public static int[][] arr;

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));

        int[][] visited = new int[N][M];
        visited[0][0] = 1;

        while (q.size() > 0) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            int z = now.z;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
                    if (arr[nx][ny] == 1) {
                        if (z == 0) {
                            q.offer(new Point(nx, ny, 1));
                            visited[nx][ny] = visited[x][y] + 1;
                        }
                    } else {
                        q.offer(new Point(nx, ny, z));
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                }
            }
        }

        return visited[N - 1][M - 1];
    }
}
