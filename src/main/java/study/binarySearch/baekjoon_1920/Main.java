package study.binarySearch.baekjoon_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;

    public static int N, M;

    public static int[] A, X;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        X = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            solution(X[i]);
        }
        System.out.println(sb);
    }

    private static void solution(int x) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == x) {
                sb.append(1 + "\n");
                return;
            } else if (A[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        sb.append(0 + "\n");
    }
}
