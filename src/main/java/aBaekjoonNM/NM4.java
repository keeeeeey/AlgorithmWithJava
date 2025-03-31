package aBaekjoonNM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM4 {

    static int N, M;

    static int[] comp;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();
        solve(0, 1);
        System.out.println(sb);
    }

    private static void solve(int l, int start) {
        if (l == M) {
            for (int x : comp) {
                sb.append(x);
                sb.append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= N; i++) {
                comp[l] = i;
                solve(l + 1, i);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        comp = new int[M];
    }
}
