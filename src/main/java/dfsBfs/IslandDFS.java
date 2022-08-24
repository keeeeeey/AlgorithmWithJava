package dfsBfs;

import java.util.Scanner;

public class IslandDFS {

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int n, answer = 0;

    public void dfs(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    dfs(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        IslandDFS il = new IslandDFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        il.solution(board);
        System.out.println(answer);
    }
}
