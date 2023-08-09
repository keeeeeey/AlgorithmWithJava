package study.divide.baekjoon_3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        long maxHigh = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxHigh = Math.min(maxHigh, arr[i]);
        }

        System.out.println(solution(N, M, arr, maxHigh));

    }

    private static Long solution(int N, int M, int[] arr, long maxHigh) {
        long left = 0;
        long right = maxHigh * M;
        long answer = Long.MAX_VALUE;
        Arrays.sort(arr);
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid / arr[i];
            }

            if (cnt < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}
