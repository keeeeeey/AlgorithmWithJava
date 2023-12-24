package practice.baekjoon_1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (pqMin.size() == pqMax.size()) pqMax.offer(num);
            else pqMin.offer(num);

            if (!pqMin.isEmpty() && !pqMax.isEmpty()) {
                if (pqMax.peek() > pqMin.peek()) {
                    int temp = pqMax.poll();
                    pqMax.offer(pqMin.poll());
                    pqMin.offer(temp);
                }
            }

            sb.append(pqMax.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
