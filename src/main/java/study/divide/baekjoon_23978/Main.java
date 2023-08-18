package study.divide.baekjoon_23978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(N, K, arr));
    }

    private static long solution(int N, long K, int[] arr) {
        long left = 1;
        long right = 1500000000;
        long answer = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = mid * (mid + 1) / 2;

            for (int i = 0; i < N - 1; i++) {
                long tmp = Math.min(mid, arr[i + 1] - arr[i]);
                temp += mid * tmp - (tmp - 1) * tmp / 2;
            }

            if (temp < K) {
                left = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }
        return answer;
    }
}
