package dfsBfs;

import java.util.Scanner;

public class FindPermutation {
    static int n, m;
    static int[] pm, ch, arr;
    public void dfs(int l) {
        if (l == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    pm[l] = arr[i];
                    ch[i] = 1;
                    dfs(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        FindPermutation fp = new FindPermutation();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc. nextInt();
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        fp.dfs(0);

    }
}
