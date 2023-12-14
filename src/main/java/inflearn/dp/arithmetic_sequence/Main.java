package inflearn.dp.arithmetic_sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int[][] dy = new int[N + 1][N + 1];
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                dy[i][j] = 2;
                int pre = 2 * nums[i] - nums[j];
                int k = 0;
                for (k = i - 1; k > 0; k--) {
                    if (nums[k] == pre) break;
                }
                dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
                answer = Math.max(answer, dy[i][j]);
            }
        }
        System.out.println(answer);
    }
}
