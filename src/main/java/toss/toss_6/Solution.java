package toss.toss_6;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] prices, int k) {
        int answer = 0;

        for (int i = 0; i < prices.length - k; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int j = i + 1; j < prices.length; j++) {
                pq.offer(prices[j]);
            }

            int temp = prices[i] * k;
            int plus = 0;
            for (int c = 0; c < k; c++) {
                plus += pq.poll();
            }

            answer = Math.max(answer, plus - temp);
        }

        if (answer > 0) {
            return answer;
        }
        return -1;
    }
}