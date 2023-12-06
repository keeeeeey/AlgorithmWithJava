package inflearn.sorting_thinking.minimum_meetingroom;

import java.util.*;

class Solution {
    public int solution(int[][] meetings){
//        int answer = 0;
//        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        for (int i = 0; i < meetings.length; i++) {
//            if (pq.isEmpty()) {
//                pq.add(meetings[i]);
//                answer = Math.max(answer, 1);
//                continue;
//            }
//
//            if (pq.peek()[1] <= meetings[i][0]) {
//                pq.poll();
//            }
//            pq.add(meetings[i]);
//            answer = Math.max(answer, pq.size());
//        }

        List<int[]> list = new ArrayList<>();
        for (int[] x : meetings) {
            list.add(new int[]{x[0], 1});
            list.add(new int[]{x[1], 2});
        }
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int answer = 0, cnt = 0;
        for (int[] x : list) {
            if (x[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}