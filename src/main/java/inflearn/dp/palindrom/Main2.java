package inflearn.dp.palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dy = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (nums[j] == nums[j + i]) dy[j][j + i] = dy[j + 1][j + i - 1];
                else {
                    dy[j][j + i] = Math.min(dy[j + 1][j + i], dy[j][j + i - 1]) + 1;
                }
            }
        }
        System.out.println(dy[1][N]);
    }
}
