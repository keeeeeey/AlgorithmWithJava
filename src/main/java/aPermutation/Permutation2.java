package aPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation2 {

    public static int N, M;

    public static int[] pm, ch, arr;

    public static void main(String[] args) throws Exception {
        input();
        solve(0);
    }

    private static void solve(int l) {
        if (l == M) {
            for (int x : pm) {
                System.out.print(x);
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[l] = arr[i];
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
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ch = new int[N];
        pm = new int[M];
    }
}
