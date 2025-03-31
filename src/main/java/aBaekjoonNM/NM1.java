package aBaekjoonNM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM1 {

    public static int N, M;

    public static int[] pm, ch;

    public static void main(String[] args) throws Exception {
        input();
        solve(0);
    }

    private static void solve(int l) {
        if (l == M) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                    pm[l] = i;
                    ch[i] = 1;
                    solve(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        pm = new int[M];
    }
}
