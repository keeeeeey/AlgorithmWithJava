package inflearn.dijkstra.ball;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] s, int[] e){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;
        int[][] costs = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(costs[i], Integer.MAX_VALUE);
        costs[s[0]][s[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{s[0], s[1], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[2] > costs[cur[0]][cur[1]]) continue;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0];
                int ny = cur[1];
                int len = cur[2];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dx[d];
                    ny += dy[d];
                    len++;
                }
                nx -= dx[d];
                ny -= dy[d];
                len--;
                if (len < costs[nx][ny]) {
                    costs[nx][ny] = len;
                    pq.offer(new int[]{nx, ny, len});
                }
            }
        }

        if (costs[e[0]][e[1]] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return costs[e[0]][e[1]];
        }
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

