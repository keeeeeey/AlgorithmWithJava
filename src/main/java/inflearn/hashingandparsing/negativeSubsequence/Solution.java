package inflearn.hashingandparsing.negativeSubsequence;

import java.util.*;

class Solution {
    public int solution(int[] nums, int m){
        int answer = 0;
//        int[] sum = new int[nums.length];
//        HashMap<Integer, Integer> sH = new HashMap<>();
//        sum[0] = nums[0];
//        sH.put(sum[0], 1);
//        sH.put(0, 1);
//        if (sum[0] == m) answer += 1;
//        for (int i = 1; i < nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i];
//            if (sH.containsKey(sum[i] - m)) answer += sH.get(sum[i] - m);
//            sH.put(sum[i], sH.getOrDefault(sum[i], 0) + 1);
//        }

        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);
        for (int x : nums) {
            sum += x;
            if (nH.containsKey(sum - m)) answer += nH.get(sum - m);
            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}