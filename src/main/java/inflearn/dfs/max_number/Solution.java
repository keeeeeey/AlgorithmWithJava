package inflearn.dfs.max_number;

import java.util.*;

class Solution {

    int answer, target, m;
    List<Integer> nums;
    int[] ch;
    boolean flag;

    public void dfs(int l, int number) {
        if (flag) return;
        if (l == m) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(l + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n){
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;
        while (tmp > 0) {
            nums.add(tmp % 10);
            tmp /= 10;
        }
        nums.sort(Comparator.naturalOrder());
        m = nums.size();
        ch = new int[m];
        dfs(0, 0);
        if (!flag) return -1;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}