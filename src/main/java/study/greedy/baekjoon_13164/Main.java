package study.greedy.baekjoon_13164;

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
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(solution(N, K, arr));
    }

    private static int solution(int N, int K, int[] arr) {
        int[] gap = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gap[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(gap);
        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += gap[i];
        }
        return answer;
    }

}
