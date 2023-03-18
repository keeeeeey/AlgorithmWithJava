package street11;

public class Problem3 {

    class Solution {
        public int solution(String S) {
            int n = S.length();
            int answer = 0;

            for (int center = 0; center < n; center++) {
                int left = center;
                int right = center + 1;

                while (left >= 0 && right < n && (S.charAt(left) == S.charAt(right) || S.charAt(left) == '?' || S.charAt(right) == '?')) {
                    left--;
                    right++;
                }

                int length = right - left - 1;

                if (length % 2 == 0 && length > answer) {
                    answer = length;
                }
            }

            return answer;
        }
    }

}
