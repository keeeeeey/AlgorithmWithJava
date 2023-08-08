package study.divide.baekjoon_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int left = 1;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int mid = 0;
        int answer = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i] / mid;
            }

            if (sum < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
