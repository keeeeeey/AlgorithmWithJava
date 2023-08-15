package study.greedy.baekjoon_21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static int[] arr;

    public static long[] dp;

    public static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[N];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        case1();
        case2();
        case3();
        System.out.println(answer);
    }

    private static void case1() {
        long bee1, bee2;

        for (int i = 1; i < N - 1; i++) {
            bee1 = dp[N - 1] - arr[0] - arr[i];
            bee2 = dp[N - 1] - dp[i];
            answer = Math.max(answer, bee1 + bee2);
        }
    }

    private static void case2() {
        long bee1, bee2;

        for (int i = 1; i < N - 1; i++) {
            bee1 = dp[N - 1] - arr[N - 1] - arr[i];
            bee2 = dp[i] - arr[i];
            answer = Math.max(answer, bee1 + bee2);
        }
    }

    private static void case3() {
        long bee1, bee2;

        for (int i = 1; i < N - 1; i++) {
            bee1 = dp[i] - arr[0];
            bee2 = dp[N - 1] - dp[i] + arr[i] - arr[N - 1];
            answer = Math.max(answer, bee1 + bee2);
        }
    }
}
