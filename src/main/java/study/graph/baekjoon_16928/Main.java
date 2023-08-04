package study.graph.baekjoon_16928;

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
        public int compareTo(Node o) {
            return this.acc - o.acc;
        }
    }

    public static class Point {
        int idx;
        boolean isShortcut;

        public Point(int idx, boolean isShortcut) {
            this.idx = idx;
            this.isShortcut = isShortcut;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Point>> graph = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            graph.add(new ArrayList<>());
        }

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Point(e, true));
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Point(e, true));
        }

        for (int i = 0; i <= 100; i++) {
            if (graph.get(i).isEmpty()) {
                for (int j = i + 1; j <= i + 6; j++) {
                    if (j <= 100) {
                        graph.get(i).add(new Point(j, false));
                    }
                }
            }
        }

        System.out.println(solution(N, M, graph));
    }

    private static int solution(int N, int M, List<List<Point>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        int[] dist = new int[101];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.cur] < now.acc) continue;

            for (int i = 0; i < graph.get(now.cur).size(); i++) {
                if (graph.get(now.cur).get(i).idx > 100) continue;

                int cost;
                if (graph.get(now.cur).get(i).isShortcut) {
                    cost = dist[now.cur];
                } else {
                    cost = dist[now.cur] + 1;
                }

                if (cost < dist[graph.get(now.cur).get(i).idx]) {
                    dist[graph.get(now.cur).get(i).idx] = cost;
                    pq.add(new Node(graph.get(now.cur).get(i).idx, cost));
                }
            }
        }

        return dist[100];
    }
}
