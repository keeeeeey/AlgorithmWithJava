package baekjoonDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Party {

    public static class Node implements Comparable<Node> {
        int cur;
        int acc;
        public Node(int cur, int acc) {
            this.cur = cur;
            this.acc = acc;
        }

        @Override
        public int compareTo(Node n) {
            return this.acc - n.acc;
        }
    }

    public static StringTokenizer st;

    public static int N, M, X;

    public static List<List<Node>> list = new ArrayList<>();

    public static int[] dist;

    public static int dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.cur] < now.acc) continue;

            for (int i = 0; i < list.get(now.cur).size(); i++) {
                Node next = list.get(now.cur).get(i);
                int cost = now.acc + next.acc;
                if (cost < dist[next.cur]) {
                    dist[next.cur] = cost;
                    pq.offer(new Node(next.cur, cost));
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            list.get(S).add(new Node(E, T));
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int a = dijkstra(i, X);
            int b = dijkstra(X, i);
            if (a + b > answer) {
                answer = a + b;
            }
        }

        System.out.println(answer);
    }
}
