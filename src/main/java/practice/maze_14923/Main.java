package practice.maze_14923;

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
        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken());
        int Hy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken());
        int Ey = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(N, M, Hx - 1, Hy - 1, Ex - 1, Ey - 1, maze));
    }

    private static int solution(int N, int M, int Hx, int Hy, int Ex, int Ey, int[][] maze) {
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[Hx][Hy] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{Hx, Hy, 0, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == Ex && now[1] == Ey) return now[2];

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maze[nx][ny] == 0 && dist[nx][ny] > now[3]) {
                        q.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                        dist[nx][ny] = now[3];
                    } else if (maze[nx][ny] == 1 && now[3] == 0 && dist[nx][ny] > now[3] + 1) {
                        q.offer(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                        dist[nx][ny] = now[3] + 1;
                    }
                }
            }

        }

        return -1;
    }
}
