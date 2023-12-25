package practice.baekjoon_1379;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new int[]{idx, s, e});
        }
        list.sort((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] rooms = new int[N];
        int K = 1;
        for (int i = 0; i < N; i++) {
            if (pq.isEmpty()) {
                pq.offer(new int[]{list.get(i)[2], 1});
                rooms[list.get(i)[0] - 1] = 1;
            } else {
                if (pq.peek()[0] <= list.get(i)[1]) {
                    int roomNum = pq.poll()[1];
                    rooms[list.get(i)[0] - 1] = roomNum;
                    pq.offer(new int[]{list.get(i)[2], roomNum});
                } else {
                    K += 1;
                    rooms[list.get(i)[0] - 1] = K;
                    pq.offer(new int[]{list.get(i)[2], K});
                }
            }
        }

        System.out.println(K);
        for (int i = 0; i < N; i++) {
            System.out.println(rooms[i]);
        }
    }
}
