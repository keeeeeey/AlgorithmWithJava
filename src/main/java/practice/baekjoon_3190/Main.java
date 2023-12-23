package practice.baekjoon_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int N, K, L;
    public static int[][] arr;
    public static Queue<Info> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            arr[row][col] = 2;
        }
        L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            Q.offer(new Info(X, C));
        }

        System.out.println(solution());
    }

    private static int solution() {
        int dir = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{0, 0});
        int t = 0;
        while (!Q.isEmpty()) {
            Info info = Q.poll();

            for (int i = t; i < info.t; i++) {
                t += 1;
                int[] head = deque.peekFirst();
                int nx = head[0] + dx[dir % 4];
                int ny = head[1] + dy[dir % 4];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 1) {
                    return t;
                }

                deque.offerFirst(new int[]{nx, ny});
                if (arr[nx][ny] == 0) {
                    int[] tail = deque.pollLast();
                    arr[tail[0]][tail[1]] = 0;
                }
                arr[nx][ny] = 1;
            }

            if (info.dir.equals("L")) dir += 3;
            else dir += 1;
        }

        while (true) {
            t += 1;
            int[] head = deque.peekFirst();
            int nx = head[0] + dx[dir % 4];
            int ny = head[1] + dy[dir % 4];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 1) {
                return t;
            }

            deque.offerFirst(new int[]{nx, ny});
            if (arr[nx][ny] == 0) {
                int[] tail = deque.pollLast();
                arr[tail[0]][tail[1]] = 0;
            }
            arr[nx][ny] = 1;
        }
    }

    public static class Info {
        int t;
        String dir;

        public Info(int t, String dir) {
            this.t = t;
            this.dir = dir;
        }
    }
}
