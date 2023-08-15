package study.divide.baekjoon_1477;

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
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;
        arr[N + 1] = L;
        Arrays.sort(arr);
        System.out.println(solution(N, M, L, arr));
    }

    private static int solution(int N, int M, int L, int[] arr) {
        int left = 1;
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 1; i < N + 2; i++) {
                sum += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if (sum > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
