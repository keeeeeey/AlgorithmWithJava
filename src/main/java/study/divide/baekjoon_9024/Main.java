package study.divide.baekjoon_9024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            solution(N, K, arr);
        }
        System.out.println(sb);
    }

    private static void solution(int N, int K, int[] arr) {
        int left = 0;
        int right = N - 1;

        int minV = Integer.MAX_VALUE;
        int cnt = 0;
        while (left < right) {
            int sumV = arr[left] + arr[right];
            int gap = Math.abs(K - sumV);
            if (minV >= gap) {
                if (minV > gap) cnt = 0;
                cnt += 1;
                minV = gap;
            }

            if (sumV >= K) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        sb.append(cnt).append("\n");
    }
}
