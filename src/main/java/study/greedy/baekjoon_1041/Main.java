package study.greedy.baekjoon_1041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        if (N == 1) {
            Arrays.sort(arr);
            for (int i = 0; i < 5; i++) {
                answer += arr[i];
            }
            System.out.println(answer);
            return;
        }

        long min = arr[0];
        for (int i = 1; i < 6; i++) {
            min = Math.min(min, arr[i]);
        }
        answer += min * ((long) (N - 2) * (N - 2) * 5 + (N - 2) * 4L);

        min = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (j + i != 5) {
                    min = Math.min(min, arr[i] + arr[j]);
                }
            }
        }
        answer += min * ((N - 2) * 8L + 4);

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Math.min(arr[i], arr[5 - i]);
        }
        answer += sum * 4L;
        System.out.println(answer);
    }
}