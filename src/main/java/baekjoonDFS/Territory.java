package baekjoonDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Territory {

    public static class Point {
        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static StringTokenizer st;

    public static int M, N, K, cnt;

    public static int[][] arr;

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    public static int answer = 0;

    public static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int ex = M - Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int sx = M - Integer.parseInt(st.nextToken());

            for (int i = sx; i < ex; i++) {
                for (int j = sy; j < ey; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        solution();

        answerList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(answer);

        for (int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }

    private static void solution() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    answer++;
                    cnt = 1;
                    arr[i][j] = 1;
                    dfs(i, j);
                    answerList.add(cnt);
                }
            }
        }
    }

    private static void dfs(int i, int j) {
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                cnt++;
                arr[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }
}
