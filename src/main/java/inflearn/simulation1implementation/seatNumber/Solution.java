package inflearn.simulation1implementation.seatNumber;

import java.util.*;

class Solution {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        if (k > c * r) return new int[]{0, 0};

        int[][] arr = new int[c][r];

        int x = 0, y = 0, dir = 0, cnt = 1;
        arr[x][y] = 1;

        while (cnt < k) {
            int nx = x + dx[dir % 4];
            int ny = y + dy[dir % 4];

            if (nx >= 0 && nx < c && ny >= 0 && ny < r && arr[nx][ny] == 0) {
                cnt += 1;
                x = nx;
                y = ny;
                arr[x][y] = 1;
            } else {
                dir += 1;
            }
        }

        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}