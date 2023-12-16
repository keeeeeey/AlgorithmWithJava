package inflearn.dp.harvest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[][] dy = new int[N + 1][N + 1];
        int[] s = new int[N + 1];
        s[1] = nums[1];
        for (int i = 2; i <= N; i++) {
            s[i] = nums[i] + s[i - 1];
        }
        for (int i = 1; i <= N; i++) {
            dy[i][i] = nums[i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                dy[j][j + i] = Math.max(dy[j + 1][j + i], dy[j][j + i - 1]) + s[j + i] - s[j - 1];
            }
        }
        System.out.println(dy[1][N]);
    }

}
