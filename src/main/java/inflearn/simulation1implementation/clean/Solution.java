package inflearn.simulation1implementation.clean;

import java.util.*;

class Solution {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        // 나의 풀이
//        int cnt = 0;
//        int dir = 0;
//        while (cnt < k) {
//            cnt += 1;
//            int nx = answer[0] + dx[dir % 4];
//            int ny = answer[1] + dy[dir % 4];
//            if (0 <= nx && nx < board.length && 0 <= ny && ny < board.length && board[nx][ny] == 0) {
//                answer[0] = nx;
//                answer[1] = ny;
//            } else {
//                dir += 1;
//            }
//        }

        // 정답 코드
        int n = board.length;
        int x = 0, y = 0, d = 0, count = 0; while(count < k){
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                continue; }
            x = nx;
            y = ny; }
        answer[0] = x; answer[1] = y;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}