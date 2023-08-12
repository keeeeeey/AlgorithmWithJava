package study.twoPointer.baekjoon_2230;

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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(solution(N, M, arr));
    }

    private static int solution(int N, int M, int[] arr) {
        int left = 0;
        int right = 1;
        int answer = Integer.MAX_VALUE;
        while (right < N) {
            int temp = arr[right] - arr[left];
            if (temp > M) {
                answer = Math.min(answer, temp);
                left += 1;
            } else if (temp < M) {
                right += 1;
            } else {
                return M;
            }
        }
        return answer;
    }
}
