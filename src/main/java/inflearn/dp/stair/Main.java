package inflearn.dp.stair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N + 1];
        int[] stair = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        dy[1] = stair[1];
        if (N >= 2) {
            dy[2] = stair[1] + stair[2];
            for (int i = 3; i <= N; i++) {
                dy[i] = Math.max(dy[i - 2] + stair[i], dy[i - 3] + stair[i - 1] + stair[i]);
            }
        }
        System.out.println(dy[N]);
    }
}
