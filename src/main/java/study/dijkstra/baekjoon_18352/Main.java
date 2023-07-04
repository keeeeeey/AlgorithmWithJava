package study.dijkstra.baekjoon_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        int[] distance = solution(N, K, X);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    private static int[] solution(int N, int K, int X) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i != X) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.cur] < now.acc) continue;

            for (int next : graph.get(now.cur)) {
                int cost = distance[now.cur] + 1;
                if (cost < distance[next]) {
                    distance[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }

        return distance;
    }

    public static class Node implements Comparable<Node> {
        int cur;
        int acc;

        public Node(int cur, int acc) {
            this.cur = cur;
            this.acc = acc;
        }

        @Override
        public int compareTo(Node now) {
            return this.acc - now.acc;
        }
    }
}
