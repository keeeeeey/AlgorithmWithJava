package a2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2644 {

    private static int n, m, from, to;
    private static int result = -1;
    private static Queue<Relationship> q = new LinkedList<>();
    private static int[] visited;
    private static final List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        q.add(new Relationship(from, 0));
        visited[from] = 1;
        solution();
        System.out.println(result);
    }

    public static void solution() {
        while (!q.isEmpty()) {
            Relationship rel = q.poll();
            visited[rel.target] = 1;

            if (rel.target == to) {
                result = rel.cnt;
                break;
            }

            for (Integer target : list.get(rel.target)) {
                if (visited[target] == 0) {
                    q.add(new Relationship(target, rel.cnt + 1));
                }
            }
        }
    }

    public static class Relationship {
        int target;
        int cnt;

        public Relationship(int me, int cnt) {
            this.target = me;
            this.cnt = cnt;
        }
    }
}
