package practice.baekjoon_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(solution(N, M, maze));
    }

    private static int solution(int N, int M, int[][] maze) {
        int[][] ch = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(ch[i], Integer.MAX_VALUE);
        ch[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == N - 1 && now[1] == M - 1) return now[2];

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maze[nx][ny] == 0 && ch[nx][ny] > now[2]) {
                        pq.offer(new int[]{nx, ny, now[2]});
                        ch[nx][ny] = now[2];
                    } else if (maze[nx][ny] == 1 && ch[nx][ny] > now[2] + 1) {
                        pq.offer(new int[]{nx, ny, now[2] + 1});
                        ch[nx][ny] = now[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
