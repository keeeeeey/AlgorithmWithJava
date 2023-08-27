package study.greedy.baekjoon_2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(solution(N, arr));
    }

    private static int solution(int N, int[] arr) {
        int[] arraySum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (arr[i] > arraySum[i] + 1) {
                return arraySum[i] + 1;
            }

            arraySum[i + 1] = arraySum[i] + arr[i];
        }
        return arraySum[N] + 1;
    }
}
