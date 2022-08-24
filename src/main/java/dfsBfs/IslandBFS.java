package dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point3 {
    int x, y;
    Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class IslandBFS {
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int n, answer = 0;
    static Queue<Point3> q = new LinkedList<>();
    public void bfs(int x, int y, int[][] board) {
        q.offer(new Point3(x, y));
        while (!q.isEmpty()) {
            Point3 temp = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    q.offer(new Point3(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    bfs(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        IslandBFS ib = new IslandBFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        ib.solution(board);
        System.out.println(answer);
    }
}
