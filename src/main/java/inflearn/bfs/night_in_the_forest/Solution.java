package inflearn.bfs.night_in_the_forest;

import java.util.*;

class Solution {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    Q.offer(new int[]{i, j});
                    int[][] ch = new int[n][m];
                    ch[i][j] = 1;
                    int L = 0;
                    while (!Q.isEmpty()) {
                        int len = Q.size();
                        L++;
                        for (int r = 0; r < len; r++) {
                            int[] cur = Q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nx = cur[0] + dx[d];
                                int ny = cur[1] + dy[d];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) {
                                    if (ch[nx][ny] == 0) {
                                        dist[nx][ny] += L;
                                        ch[nx][ny] = 1;
                                        Q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}