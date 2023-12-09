package inflearn.dijkstra.wall;

import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        int[][][] dist = new int[n][m][2];
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == 1) {
                        if (dist[nx][ny][0] == 0) {
                            dist[nx][ny][0] = dist[cur[0]][cur[1]][0] + 1;
                            dist[nx][ny][1] = dist[cur[0]][cur[1]][1] + 1;
                            Q.offer(new int[]{nx, ny});
                        } else {
                            if (dist[nx][ny][1] > dist[cur[0]][cur[1]][1] + 1) {
                                dist[nx][ny][0] = dist[cur[0]][cur[1]][0] + 1;
                                dist[nx][ny][1] = dist[cur[0]][cur[1]][1] + 1;
                                Q.offer(new int[]{nx, ny});
                            }
                        }
                    } else {
                        if (dist[nx][ny][0] == 0) {
                            dist[nx][ny][0] = dist[cur[0]][cur[1]][0] + 1;
                            dist[nx][ny][1] = dist[cur[0]][cur[1]][1];
                            Q.offer(new int[]{nx, ny});
                        } else {
                            if (dist[nx][ny][1] > dist[cur[0]][cur[1]][1]) {
                                dist[nx][ny][0] = dist[cur[0]][cur[1]][0] + 1;
                                dist[nx][ny][1] = dist[cur[0]][cur[1]][1];
                                Q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return dist[n - 1][m - 1][1];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 0, 0},{0, 1, 0, 1, 0},{0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}}));
    }
}