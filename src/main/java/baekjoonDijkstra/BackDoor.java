package baekjoonDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BackDoor {

    public static class Point implements Comparable<Point> {
        int cur;
        int acc;

        public Point(int cur, int acc) {
            this.cur = cur;
            this.acc = acc;
        }

        @Override
        public int compareTo(Point p) {
            return this.acc - p.acc;
        }

    }

    public static int N, M;

    public static StringTokenizer st;

    public static int[] ward;

    public static List<List<Point>> adjList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ward = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ward[i] = Integer.parseInt(st.nextToken());
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Point(b, t));
            adjList.get(b).add(new Point(a, t));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        int[] dist = new int[N];

        for (int i = 1; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0));

        while (pq.size() > 0) {
            Point now = pq.poll();

            if (dist[now.cur] < now.acc) continue;

            for (int i = 0; i < adjList.get(now.cur).size(); i++) {
                Point next = adjList.get(now.cur).get(i);
                if (next.cur == N - 1 || ward[next.cur] == 0 && dist[next.cur] > dist[now.cur] + next.acc) {
                    dist[next.cur] = dist[now.cur] + next.acc;
                    pq.offer(new Point(next.cur, dist[now.cur] + next.acc));
                }
            }
        }

        if (dist[N - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[N - 1];
        }
    }

}
