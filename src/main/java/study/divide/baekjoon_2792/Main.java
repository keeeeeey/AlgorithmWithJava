package study.divide.baekjoon_2792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 0;
        int[] jemList = new int[M];
        for (int i = 0; i < M; i++) {
            jemList[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, jemList[i]);
        }

        int mid = 0;
        int answer = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += jemList[i] / mid;
                if (jemList[i] % mid != 0) {
                    sum += 1;
                }
            }

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
