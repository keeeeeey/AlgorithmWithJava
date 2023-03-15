package gabia;

import java.util.*;

class Solution {
    public static class Coffee {

        int idx;

        int time;

        public Coffee(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public int[] solution(int N, int[] coffee_times) {
        int l = coffee_times.length;
        int[] answer = new int[l];

        PriorityQueue<Coffee> pq = new PriorityQueue<>(N, new Comparator<Coffee>() {
            @Override
            public int compare(Coffee o1, Coffee o2) {
                if (o1.time == o2.time) {
                    return o1.idx - o2.idx;
                } else {
                    return o1.time - o2.time;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            pq.add(new Coffee(i, coffee_times[i]));
        }

        int cnt = N;

        for (int i = 0; i < l; i++) {
            if (!pq.isEmpty()) {
                Coffee coffee = pq.poll();
                answer[i] = coffee.idx + 1;
                if (cnt < l) {
                    pq.add(new Coffee(cnt, coffee_times[cnt] + coffee.time));
                    cnt++;
                }
            }
        }

        return answer;
    }
}