package practice.baekjoon_14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] itemCnt = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }

        List<List<int[]>> info = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) info.add(new ArrayList<>());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            info.get(s).add(new int[]{e, l});
            info.get(e).add(new int[]{s, l});
        }

        for (int i = 1; i <= n; i++) {
            solution(n, m, itemCnt, info, i);
        }

        System.out.println(answer);
    }

    private static void solution(int n, int m, int[] itemCnt, List<List<int[]>> info, int start) {
        int cnt = itemCnt[start];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (dist[now[0]] < now[1]) continue;

            for (int i = 0; i < info.get(now[0]).size(); i++) {
                int cost = dist[now[0]] + info.get(now[0]).get(i)[1];
                if (cost <= m && cost < dist[info.get(now[0]).get(i)[0]]) {
                    if (dist[info.get(now[0]).get(i)[0]] == Integer.MAX_VALUE) {
                        cnt += itemCnt[info.get(now[0]).get(i)[0]];
                    }
                    dist[info.get(now[0]).get(i)[0]] = cost;
                    pq.offer(new int[]{info.get(now[0]).get(i)[0], cost});
                }
            }
        }

        answer = Math.max(answer, cnt);
    }
}
