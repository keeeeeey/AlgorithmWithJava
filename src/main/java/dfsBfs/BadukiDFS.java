package dfsBfs;

import java.util.Scanner;

public class BadukiDFS {
    static int answer = Integer.MIN_VALUE, c, n;
    public void dfs(int l, int sum, int[] arr) {
        if (sum > c) {
            return;
        }

        if (l == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(l + 1, sum + arr[l], arr);
            dfs(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        BadukiDFS bd = new BadukiDFS();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bd.dfs(0, 0, arr);
        System.out.println(answer);
    }
}
