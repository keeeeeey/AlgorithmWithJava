package baekjoonDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Alphabet {

    public static class Point {
        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = {1, -1, 0, 0};

    public static int[] dy = {0, 0, 1, -1};

    public static char[][] arr;

    public static int R, C;

    public static HashMap<Character, Integer> map = new HashMap<>();

    public static int answer = 1;

    public static int result = 1;

    public static void dfs(int i, int j) {
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !map.containsKey(arr[nx][ny])) {
                map.put(arr[nx][ny], map.getOrDefault(arr[nx][ny], 0));
                answer += 1;

                if (result < answer) {
                    result = answer;
                }

                dfs(nx, ny);
                answer -= 1;
                map.remove(arr[nx][ny]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        map.put(arr[0][0], map.getOrDefault(arr[0][0], 0));
        dfs(0, 0);
        System.out.println(result);
    }
}
