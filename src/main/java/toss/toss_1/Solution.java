package toss.toss_1;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        solution("1451232125", 2);
    }

    public static int solution(String s, int N) {
        int answer = 0;

        for (int i = 0; i < s.length() - N; i++) {
            String temp = "";
            int[] check = new int[N + 1];
            for (int j = i; j < i + N; j++) {
                int stringToInt = s.charAt(j) - '0';
                if (stringToInt > N) {
                    break;
                }
                temp += stringToInt;
                check[stringToInt] = 1;
            }

            if (Arrays.stream(check).sum() == N) {
                answer = Math.max(answer, Integer.parseInt(temp));
            }
        }

        return answer;
    }
}
