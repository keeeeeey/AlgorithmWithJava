package study.divide.baekjoon_2776;

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
            int N = Integer.parseInt(br.readLine());
            int[] arr1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());
                solution(temp, N, arr1);
            }
        }
        System.out.println(sb);
    }

    private static void solution(int temp, int N, int[] arr1) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr1[mid] < temp) {
                left = mid + 1;
            } else if (arr1[mid] > temp) {
                right = mid - 1;
            } else {
                sb.append(1).append("\n");
                return;
            }
        }
        sb.append(0).append("\n");
    }
}
