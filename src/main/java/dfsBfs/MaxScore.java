package dfsBfs;

import java.util.Scanner;

public class MaxScore {
    static int n, m, answer = Integer.MIN_VALUE;
    public void dfs(int l, int t, int s, int[][] arr) {
        if (t > m) {
            return;
        }

        if (l == n) {
            answer = Math.max(answer, s);
        } else {
            dfs(l + 1, t + arr[l][1], s + arr[l][0], arr);
            dfs(l + 1, t, s, arr);
        }
    }

    public static void main(String[] args) {
        MaxScore ms = new MaxScore();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        ms.dfs(0, 0, 0, arr);
        System.out.println(answer);
    }
}
