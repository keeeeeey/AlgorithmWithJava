package study.greedy.baekjoon_1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start - o2.start;
            }
        });

        pq.offer(new Node(arr[0][1] - arr[0][0], arr[0][1]));
        for (int i = 1; i < N; i++) {
            Node now = pq.peek();
            if (now.start > arr[i][1]) {
                pq.offer(new Node(arr[i][1] - arr[i][0], arr[i][1]));
            } else {
                pq.offer(new Node(now.start - arr[i][0], now.start));
            }
        }

        if (pq.peek().start < 0) {
            System.out.println(-1);
        } else {
            System.out.println(pq.peek().start);
        }
    }
}
