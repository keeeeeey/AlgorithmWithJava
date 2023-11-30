package inflearn.simulation1implementation.puppy;

import java.util.*;

class Solution {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] board){
        int answer = 0;

        int dirH = 3;
        int dirD = 3;
        int xH = 0;
        int yH = 0;
        int xD = 0;
        int yD = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    xH = i;
                    yH = j;
                    board[i][j] = 0;
                }

                if (board[i][j] == 3) {
                    xD = i;
                    yD = j;
                    board[i][j] = 0;
                }
            }
        }

        while (answer < 10000) {
            answer += 1;
            int nxH = xH + dx[dirH % 4];
            int nyH = yH + dy[dirH % 4];
            int nxD = xD + dx[dirD % 4];
            int nyD = yD + dy[dirD % 4];

            if (nxH >= 0 && nxH < 10 && nyH >= 0 && nyH < 10 && board[nxH][nyH] == 0) {
                xH = nxH;
                yH = nyH;
            } else {
                dirH += 1;
            }

            if (nxD >= 0 && nxD < 10 && nyD >= 0 && nyD < 10 && board[nxD][nyD] == 0) {
                xD = nxD;
                yD = nyD;
            } else {
                dirD += 1;
            }

            if (xH == xD && yH == yD) {
                break;
            }
        }

        if (answer >= 10000) {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
