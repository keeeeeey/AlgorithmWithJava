package study.cumulative.baekjoon_16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[][] dp = new int[str.length() + 1][26];
        dp[1][str.charAt(0) - 'a'] = 1;
        for (int i = 2; i <= str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][str.charAt(i - 1) - 'a'] = dp[i - 1][str.charAt(i - 1) - 'a'] + 1;
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(dp[r + 1][a - 'a'] - dp[l][a - 'a']).append("\n");
        }
        System.out.println(sb);
    }
}
