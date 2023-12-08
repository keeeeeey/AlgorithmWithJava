package inflearn.bfs.maze;

import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(int[][] board){
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        int[][] dist = new int[7][7];
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && dist[nx][ny] == 0) {
                    if (nx == 6 && ny == 6) return dist[cur[0]][cur[1]] + 1;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}