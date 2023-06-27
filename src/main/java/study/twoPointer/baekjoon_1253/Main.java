package study.twoPointer.baekjoon_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left += 1;
                    continue;
                } else if (right == i) {
                    right -= 1;
                    continue;
                }

                if (arr[left] + arr[right] > arr[i]) {
                    right -= 1;
                } else if (arr[left] + arr[right] < arr[i]) {
                    left += 1;
                } else {
                    answer += 1;
                    break;
                }
            }
        }

        return answer;
    }
}
