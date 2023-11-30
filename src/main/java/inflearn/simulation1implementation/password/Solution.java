package inflearn.simulation1implementation.password;

import java.util.*;

class Solution {

    public static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    public static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    public int solution(int[] keypad, String password){
        int answer = 0;
        int[][] pad = new int[3][3];
        for (int i = 0; i < 9; i++) {
            pad[i / 3][i % 3] = keypad[i];
        }

//        int x = 0, y = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (pad[i][j] == password.charAt(0) - '0') {
//                    x = i;
//                    y = j;
//                }
//            }
//        }
//
//        for (int i = 1; i < password.length(); i++) {
//            while (true) {
//                if (password.charAt(i) - '0' == pad[x][y]) break;
//                boolean flag = false;
//                for (int d = 0; d < 8; d++) {
//                    int nx = x + dx[d];
//                    int ny = y + dy[d];
//                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
//                        if (password.charAt(i) - '0' == pad[nx][ny]) {
//                            x = nx;
//                            y = ny;
//                            answer += 1;
//                            flag = true;
//                        }
//                    }
//                }
//
//                if (!flag) {
//                    x = 1;
//                    y = 1;
//                    answer += 1;
//                } else {
//                    break;
//                }
//            }
//        }

        int[][] dist = new int[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 0; i < 10; i++) dist[i][i] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) {
                        int to = pad[i + dx[k]][j + dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < password.length() - 1; i++) {
            answer += dist[password.charAt(i) - '0'][password.charAt(i + 1) - '0'];
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
