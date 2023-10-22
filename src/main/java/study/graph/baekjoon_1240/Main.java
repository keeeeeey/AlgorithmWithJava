package study.graph.baekjoon_1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int cur;
        int acc;

        public Node(int cur, int acc) {
            this.cur = cur;
            this.acc = acc;
        }

        @Override
        public int compareTo(Node node) {
            return this.acc - node.acc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<int[]>> nodeList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            nodeList.get(start).add(new int[]{end, distance});
            nodeList.get(end).add(new int[]{start, distance});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dijkstra(N, start, end, nodeList));
        }

    }

    private static int dijkstra(int N, int start, int end, List<List<int[]>> nodeList) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.cur] < now.acc) continue;

            for (int[] next : nodeList.get(now.cur)) {
                int cost = dist[now.cur] + next[1];
                if (dist[next[0]] > cost) {
                    dist[next[0]] = cost;
                    pq.offer(new Node(next[0], cost));
                }
            }
        }

        return dist[end];
    }
}
