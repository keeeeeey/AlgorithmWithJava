package aBaekjoonNM;

import java.io.*;
import java.util.StringTokenizer;

public class NM3 {

    static int N, M;

    static int[] pm;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();
        solve(0);
        System.out.println(sb);
    }

    private static void solve(int l) {
        if (l == M) {
            for (int x : pm) {
                sb.append(x);
                sb.append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                pm[l] = i;
                solve(l + 1);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M];
    }
}
