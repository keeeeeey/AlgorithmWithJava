package inflearn.datastructure.longestSequence;

import java.util.*;

class Solution {
    public int solution(int[] nums){
        // HashSet은 Hash 값으로 저장하기 때문에 해당 값이 있는지 조회할때는 시간 복잡도 O(1)을 갖는다.
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int x : set) {
            if (set.contains(x - 1)) continue;
            int cnt = 0;
            while (set.contains(x)) {
                cnt += 1;
                x += 1;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}