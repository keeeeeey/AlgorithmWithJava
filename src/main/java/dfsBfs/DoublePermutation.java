package dfsBfs;

import java.util.Scanner;

public class DoublePermutation {
    static int[] pm;
    static int n, m;
    public void dfs(int l) {
        if (l == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                dfs(l + 1);
            }
        }
    }

    public static void main(String[] args) {
        DoublePermutation dp = new DoublePermutation();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        dp.dfs(0);
    }
}
