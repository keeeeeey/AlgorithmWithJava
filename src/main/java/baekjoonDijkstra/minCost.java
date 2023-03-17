package baekjoonDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class minCost {

    public static class Node {
        int cur;
        int acc;

        public Node(int cur, int acc) {
            this.cur = cur;
            this.acc = acc;
        }
    }

    public static StringTokenizer st;

    public static int N, M;

    public static List<List<Node>> list = new ArrayList<>();

    public static int dijkstra(int A, int B) {
        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[A] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.acc - o2.acc;
            }
        });

        pq.offer(new Node(A, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.cur] < node.acc) {
                continue;
            }

            for (int i = 0; i < list.get(node.cur).size(); i++) {
                Node next = list.get(node.cur).get(i);
                int cost = node.acc + next.acc;
                if (cost < dist[next.cur]) {
                    dist[next.cur] = cost;
                    pq.offer(new Node(next.cur, cost));
                }
            }

        }
        return dist[B];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(A, B));
    }
}
