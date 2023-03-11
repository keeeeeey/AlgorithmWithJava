package baekjoonBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class iceberg {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static StringTokenizer st;

    public static int N, M;

    public static int[][] arr;

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    public static int answer = 0;

    private static void subtract(int[][] meltingCntArr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (meltingCntArr[i][j] != 0) {
                    if (arr[i][j] >= meltingCntArr[i][j]) {
                        arr[i][j] -= meltingCntArr[i][j];
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int bfs() {
        int iceCnt = 0;

        Queue<Point> q = new LinkedList<>();

        int[][] visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && visited[i][j] == 0) {
                    iceCnt += 1;
                    visited[i][j] = 1;
                    q.offer(new Point(i, j));
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        int x = p.x;
                        int y = p.y;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0 && visited[nx][ny] == 0) {
                                visited[nx][ny] = 1;
                                q.offer(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
        }

        return iceCnt;
    }

    private static void melting() {
        while (true) {
            int returnValue = bfs();
            if (returnValue >= 2) {
                break;
            } else if (returnValue == 0) {
                answer = 0;
                break;
            }

            int[][] meltingCntArr = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0) {
                        int meltingCnt = 0;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                                meltingCnt += 1;
                            }
                        }
                        meltingCntArr[i][j] = meltingCnt;
                    }
                }
            }

            subtract(meltingCntArr);
            answer += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        melting();
        System.out.println(answer);
    }
}
