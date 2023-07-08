package toss.toss_2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        solution(new int[][] {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 1, 2);
    }

    public static List<ArrayList<Integer>> relationship = new ArrayList<>();

    public static int solution(int[][] relationships, int target, int limit) {
        int answer = 0;

        int N = 0;

        for (int i = 0; i < relationships.length; i++) {
            N = Math.max(N, relationships[i][0]);
            N = Math.max(N, relationships[i][1]);
        }

        for (int i = 0; i <= N; i++) {
            relationship.add(new ArrayList<>());
        }

        for (int i = 0; i < relationships.length; i++) {
            int r1 = relationships[i][0];
            int r2 = relationships[i][1];
            relationship.get(r1).add(r2);
            relationship.get(r2).add(r1);
        }

        int[] result = dijkstra(N, target);

        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (i == target) continue;

            if (result[i] == 1) {
                answer += 5;
            } else if (result[i] > 1 && result[i] <= limit) {
                answer += 11;
            }
        }

        return answer;
    }

    private static int[] dijkstra(int N, int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i != target) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        pq.offer(new Node(target, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.cur] < now.acc) continue;

            for (int next : relationship.get(now.cur)) {
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
