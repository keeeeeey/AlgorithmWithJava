package study.programmers.hIndex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int lastIdx = citations.length - 1;
        int maxV = citations[lastIdx];

        for (int h = 0; h <= maxV; h++) {
            int temp = 0;
            for (int i = 0; i <= lastIdx; i++) {
                if (citations[i] >= h) {
                    temp = i;
                    break;
                }
            }

            if (lastIdx - temp + 1 >= h && temp <= h) {
                answer = Math.max(answer, h);
            }
        }

        return answer;
    }
}
