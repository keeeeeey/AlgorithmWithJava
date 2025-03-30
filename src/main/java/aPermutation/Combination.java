package aPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {

    public static int N, M;

    public static int[] comp;

    public static void main(String[] args) throws Exception {
        input();
        solve(0, 1);
    }

    private static void solve(int l, int start) {
        if (l == M) {
            for (int x : comp) {
                System.out.print(x);
            }
            System.out.println();
        } else {
            for (int i = start; i <= N; i++) {
                comp[l] = i;
                solve(l + 1, i + 1);
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
