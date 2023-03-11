package baekjoonDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorWeakness {

    public static int N;

    public static int[][] weakArr;

    public static int[][] normalArr;

    public static int weak = 0;

    public static int normal = 0;

    public static int[][] weakVisited;

    public static int[][] normalVisited;

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    private static void weakDFS(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && weakVisited[nx][ny] == 0 && weakArr[x][y] == weakArr[nx][ny]) {
                weakVisited[nx][ny] = 1;
                weakDFS(nx, ny);
            }
        }
    }

    private static void normalDFS(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && normalVisited[nx][ny] == 0 && normalArr[x][y] == normalArr[nx][ny]) {
                normalVisited[nx][ny] = 1;
                normalDFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weakArr = new int[N][N];
        normalArr = new int[N][N];
        weakVisited = new int[N][N];
        normalVisited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                normalArr[i][j] = str.charAt(j);
                if (str.charAt(j) == 'G') {
                    weakArr[i][j] = 'R';
                } else {
                    weakArr[i][j] = str.charAt(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (weakVisited[i][j] == 0) {
                    weak += 1;
                    weakVisited[i][j] = 1;
                    weakDFS(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (normalVisited[i][j] == 0) {
                    normal += 1;
                    normalVisited[i][j] = 1;
                    normalDFS(i, j);
                }
            }
        }

        System.out.println(normal + " " + weak);
    }
}
