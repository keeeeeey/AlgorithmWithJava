package baekjoonDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LinkedElementCnt {

    public static StringTokenizer st;

    public static int[] visited;

    public static List<List<Integer>> list = new ArrayList<>();

    public static int answer = 0;

    public static void dfs(int idx) {
        for (int i = 0; i < list.get(idx).size(); i++) {
            if (visited[list.get(idx).get(i)] == 0) {
                visited[list.get(idx).get(i)] = 1;
                dfs(list.get(idx).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                answer += 1;
                visited[i] = 1;
                dfs(i);
            }
        }

        System.out.println(answer);
    }
}
