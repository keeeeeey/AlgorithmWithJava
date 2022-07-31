package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SavePrincess sp = new SavePrincess();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(sp.solution(n, k));
    }
}
