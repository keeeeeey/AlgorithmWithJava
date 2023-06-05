package study.dp.stair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stair {

    public static int N;

    public static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N];

        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }
}

// 10, 20, 15, 25, 10, 20
// 10, 30, 35, 55, 65, 75
