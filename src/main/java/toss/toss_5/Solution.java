package toss.toss_5;

public class Solution {

    public int solution(int A, int B, int C, int D, int N, int[][] Chips) {
        // 케이크: A cm x B cm
        // 직사각형 틀: C cm x D cm
        // 초콜릿 칩: N개
        // 초콜릿 칩의 좌표 xn, yn: (Chips[n-1][0], Chips[n-1][1])
        int answer = 0;

        int[][] cake = new int[B + 1][A + 1];

        int cnt = 0;
        for (int[] chip : Chips) {
            int x = chip[0];
            int y = chip[1];
            cnt += 1;
            cake[y][x] = cnt;
        }

        return answer;
    }
}
