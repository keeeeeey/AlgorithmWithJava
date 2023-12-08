package inflearn.bfs.catch_calf;

import java.util.*;

class Solution {
    public int solution(int s, int e){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        int[][] ch = new int[2][200001];
        ch[0][s] = 1;
        while (!Q.isEmpty()) {
            int len = Q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();
                for (int nx : new int[]{cur + 1, cur - 1, cur * 2}) {
                    if (nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0) {
                        ch[L % 2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e += L;
            if (e > 200000) return -1;
            if (ch[L % 2][e] == 1) return L;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}