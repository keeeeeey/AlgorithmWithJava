package study.greedy.baekjoon_12931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrB = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arrB));
    }

    private static int solution(int N, int[] arrB) {
        int answer = 0;

        while (Arrays.stream(arrB).sum() > 0) {
            answer += 1;
            if (hasOddNumber(N, arrB)) {
                for (int i = 0; i < N; i++) {
                    if (arrB[i] % 2 == 1) {
                        arrB[i] -= 1;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < N; i++) {
                    if (arrB[i] % 2 == 0) {
                        arrB[i] /= 2;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean hasOddNumber(int N, int[] arrB) {
        for (int i = 0; i < N; i++) {
            if (arrB[i] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
