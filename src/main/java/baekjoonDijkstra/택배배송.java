package baekjoonDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 택배배송 {

    public static int N, M;

    public static List<List<Point>> roads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            roads.get(A - 1).add(new Point(B - 1, C));
            roads.get(B - 1).add(new Point(A - 1, C));
        }
    }

    private static int solve() {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0));
        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (dist[now.cur] < now.acc) continue;

            for (int i = 0; i < roads.get(now.cur).size(); i++) {
                Point next = roads.get(now.cur).get(i);
                int cost = dist[now.cur] + next.acc;
                if (cost < dist[next.cur]) {
                    dist[next.cur] = cost;
                    pq.offer(new Point(next.cur, cost));
                }
            }
        }
        return dist[N - 1];
    }
}

class Point implements Comparable<Point> {
    int cur, acc;

    public Point(int cur, int acc) {
        this.cur = cur;
        this.acc = acc;
    }

    @Override
    public int compareTo(Point point) {
        return this.acc - point.acc;
    }
}
