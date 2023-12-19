package practice.baekjoon_14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(solution(N, M, K, arr));
    }

    private static int solution(int N, int M, int K, int[][] arr) {
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0, 1, 0});
        while (!Q.isEmpty()) {
            int[] now = Q.poll();

            if (now[0] == N - 1 && now[1] == M - 1) return now[2];

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0 && dist[nx][ny] > now[3]) {
                        Q.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                        dist[nx][ny] = now[3];
                    } else if (arr[nx][ny] == 1 && now[3] < K && dist[nx][ny] > now[3] + 1) {
                        Q.offer(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                        dist[nx][ny] = now[3] + 1;
                    }
                }
            }
        }

        return -1;
    }
}
