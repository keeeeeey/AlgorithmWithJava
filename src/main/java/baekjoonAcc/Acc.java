package baekjoonAcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acc {

    public static StringTokenizer st;

    public static int N, M;

    public static int[] accSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        accSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int acc = 0;
        for (int i = 1; i <= N; i++) {
            acc += Integer.parseInt(st.nextToken());
            accSum[i] = acc;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(accSum[end] - accSum[start - 1]);
        }
    }
}
