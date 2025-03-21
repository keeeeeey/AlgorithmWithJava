package baekjoonGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로만들기 {

    public static int[] dx = {0, 0, 1, -1};

    public static int[] dy = {1, -1, 0, 0};

    public static int n;

    public static int[][] maze;

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }
    }

    private static int solve() {
        int[][] visit = new int[n][n];
        visit[0][0] = 1;
        int[][] cost = new int[n][n];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (maze[nx][ny] == 1) {
                        // 이미 방문한 흰방
                        if (visit[nx][ny] == 1) {
                            if (now.cnt < cost[nx][ny]) {
                                cost[nx][ny] = now.cnt;
                                q.offer(new Point(nx, ny, now.cnt));
                            }
                        }
                        // 아직 방문하지 않은 흰방
                        else {
                            visit[nx][ny] = 1;
                            cost[nx][ny] = now.cnt;
                            q.offer(new Point(nx, ny, now.cnt));
                        }
                    } else {
                        // 이미 방문한 검은방
                        if (visit[nx][ny] == 1) {
                            if (now.cnt + 1 < cost[nx][ny]) {
                                cost[nx][ny] = now.cnt + 1;
                                q.offer(new Point(nx, ny, now.cnt + 1));
                            }
                        }
                        // 아직 방문하지 않은 검은방
                        else {
                            visit[nx][ny] = 1;
                            cost[nx][ny] = now.cnt + 1;
                            q.offer(new Point(nx, ny, now.cnt + 1));
                        }
                    }
                }
            }
        }

        return cost[n - 1][n - 1];
    }
}

class Point {
    int x, y, cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
