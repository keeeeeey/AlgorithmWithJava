package dfsBfs;

import java.util.Scanner;

public class AmazonInterview {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;
    public void dfs(int l, int sum, int[] arr) {
        if (flag) {
            return;
        }

        if (sum > total / 2) {
            return;
        }

        if (l == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(l + 1, sum + arr[l], arr);
            dfs(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        AmazonInterview ai = new AmazonInterview();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        ai.dfs(0, 0, arr);
        System.out.println(answer);
    }
}
