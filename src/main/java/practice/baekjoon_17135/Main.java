package practice.baekjoon_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M, D, answer = 0;
    public static int[][] arr;
    public static int[] ch;
    public static int[] dx = {0, -1, 0};
    public static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        ch = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }

    private static void combination(int l, int start) {
        if (l == 3) {
            gameStart();
        } else {
            for (int i = start; i < M; i++) {
                ch[i] = 1;
                combination(l + 1, i + 1);
                ch[i] = 0;
            }
        }
    }

    private static void gameStart() {
        int temp = 0;
        int[][] check = new int[N][M];

        Queue<int[]> Q = new LinkedList<>();
        for (int i = N - 1; i >= 0; i--) {
            for (int a = 0; a < M; a++) {
                if (ch[a] == 1) {
                    if (arr[i][a] == 1 && check[i][a] == 0) {
                        temp += 1;
                        check[i][a] = 1;
                        continue;
                    }
                    if (D > 1) Q.offer(new int[]{i, a});
                    boolean isShoot = false;
                    while (!Q.isEmpty()) {
                        for (int k = 0; k < Q.size(); k++) {
                            int[] node = Q.poll();
                            for (int dir = 0; dir < 3; dir++) {
                                int nx = node[0] + dx[dir];
                                int ny = node[1] + dy[dir];
                                if (nx >= 0 && ny >= 0 && ny < M && inDist(i + 1, a, nx, ny)) {
                                    if (arr[nx][ny] == 1) {
                                        if (check[i][a] == 0) {
                                            temp += 1;
                                            check[i][a] = 1;
                                        }
                                        isShoot = true;
                                        break;
                                    }
                                    Q.offer(new int[]{nx, ny});
                                }
                            }
                            if (isShoot) break;
                        }
                        if (isShoot) break;
                    }
                }
            }
        }
        answer = Math.max(answer, temp);
    }

    private static boolean inDist(int r, int a, int j, int k) {
        return Math.abs(r - j) + Math.abs(a - k) <= D;
    }
}
