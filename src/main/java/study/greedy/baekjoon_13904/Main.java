package study.greedy.baekjoon_13904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Task {
        int left;
        int score;

        public Task(int left, int score) {
            this.left = left;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Task[] arr = new Task[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.left - o1.left;
            }
        });

        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.score - o1.score;
            }
        });

        int answer = 0;
        int idx = 0;
        for (int i = arr[0].left; i > 0; i--) {
            while (idx < N && arr[idx].left >= i) {
                pq.offer(arr[idx]);
                idx += 1;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll().score;
            }
        }
        System.out.println(answer);
    }
}
