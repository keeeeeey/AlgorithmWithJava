package study.cumulative.leftSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;

    public static int N, M;

    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static long solution() {
        long[] leftArr = new long[M];
        for (int i = 1; i <= N; i++) {
            leftArr[(int) (arr[i] % M)] += 1;
        }

        long answer = leftArr[0];

        for (int i = 0; i < M; i++) {
            if (leftArr[i] > 1) {
                answer += leftArr[i] * (leftArr[i] - 1) / 2;
            }
        }
        return answer;
    }
}
