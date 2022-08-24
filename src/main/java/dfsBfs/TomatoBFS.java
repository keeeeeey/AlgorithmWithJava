package dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
    int x, y;
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class TomatoBFS {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] board, dis;
    static Queue<Point2> q = new LinkedList<>();
    public void bfs() {
        while (!q.isEmpty()) {
            Point2 temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Point2(nx, ny));
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        TomatoBFS bfs = new TomatoBFS();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    q.offer(new Point2(i, j));
                }
            }
        }
        bfs.bfs();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (answer < dis[i][j]) {
                        answer = dis[i][j];
                    }
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
