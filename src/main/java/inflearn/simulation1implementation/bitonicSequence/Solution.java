package inflearn.simulation1implementation.bitonicSequence;

import java.util.*;

class Solution {
    public int solution(int[] nums){
        int answer = 0;
//        int cnt = 1;
//        boolean isUp = true;
//        for (int i = 1; i < nums.length; i++) {
//            if (isUp) {
//                if (nums[i] == nums[i - 1]) {
//                    answer = Math.max(answer, cnt);
//                    cnt = 1;
//                } else if (nums[i] < nums[i - 1]) {
//                    isUp = false;
//                    cnt += 1;
//                } else {
//                    cnt += 1;
//                }
//            } else {
//                if (nums[i] == nums[i - 1]) {
//                    answer = Math.max(answer, cnt);
//                    cnt = 1;
//                    isUp = true;
//                } else if (nums[i] < nums[i - 1]) {
//                    cnt += 1;
//                } else {
//                    answer = Math.max(answer, cnt);
//                    cnt = 2;
//                    isUp = true;
//                }
//            }
//
//            if (i == nums.length - 1) {
//                answer = Math.max(answer, cnt);
//            }
//        }

        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();
        for(int i = 1; i < n-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peaks.add(i);
            }
        }
        for(int x : peaks){
            int left = x;
            int right = x;
            int cnt = 1;
            while(left-1 >= 0 && nums[left-1] < nums[left]){
                left--;
                cnt++;
            }
            while(right+1 < n && nums[right] > nums[right+1]){
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}