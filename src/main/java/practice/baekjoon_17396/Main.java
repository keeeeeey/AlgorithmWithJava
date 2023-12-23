package practice.baekjoon_17396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        System.out.println(solution());
    }

    private static long solution() {
        long[] ch = new long[N];
        Arrays.fill(ch, Long.MAX_VALUE);
        ch[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cur == N - 1) return ch[N - 1];
            if (now.acc > ch[now.cur] || arr[now.cur] == 1) continue;
            for (int i = 0; i < graph.get(now.cur).size(); i++) {
                int next = graph.get(now.cur).get(i).cur;
                long cost = now.acc + graph.get(now.cur).get(i).acc;
                if (cost < ch[next]) {
                    ch[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }

        return -1;
    }

    public static class Node implements Comparable<Node> {
        int cur;
        long acc;

        public Node(int cur, long acc) {
            this.cur = cur;
            this.acc = acc;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.acc, node.acc);
        }
    }
}
