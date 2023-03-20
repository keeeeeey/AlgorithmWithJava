package baekjoonPq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sumba {

    public static class Node {
        private int cur;
        private int acc;

        public Node(int cur, int acc) {
            this.cur = cur;
            this.acc = acc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[K * 2];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.acc - o2.acc;
            }
        });

        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.cur] < now.acc) continue;

            for (Node node : new Node[]{new Node(now.cur + 1, 1), new Node(now.cur - 1, 1), new Node(now.cur * 2, 0)}) {
                int cost = dist[now.cur] + node.acc;
                if (cost < dist[node.cur]) {
                    dist[node.cur] = cost;
                }
            }
        }

    }
}
