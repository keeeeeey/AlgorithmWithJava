package study.string.baekjoon_12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(solution(S, T));
    }

    private static int solution(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }

        int ans = 0;
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            ans += solution(s, string);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            ans += solution(s, t.substring(0, t.length() - 1));
        }

        return ans > 0 ? 1 : 0;
    }
}
