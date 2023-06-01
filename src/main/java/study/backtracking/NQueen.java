package study.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    public static int N, answer;

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        solution(0);
        System.out.println(answer);
    }

    private static void solution(int l) {
        if (l == N) {
            answer += 1;
        } else {
            for (int i = 0; i < N; i++) {
                arr[l] = i;
                if (check(l)) {
                    solution(l + 1);
                }
            }
        }
    }

    private static boolean check(int l) {
        for (int row = 0; row < l; row++) {
            if (arr[row] == arr[l] || Math.abs(row - l) == Math.abs(arr[row] - arr[l])) return false;
        }

        return true;
    }
}
