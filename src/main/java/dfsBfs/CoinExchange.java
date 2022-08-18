package dfsBfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {
    static int n, m, answer = Integer.MAX_VALUE;

    public void dfs(int l, int sum, Integer[] arr) {
        if (sum > m) {
            return;
        }

        if (l >= answer) {
            return;
        }

        if (sum == m) {
            answer = Math.min(answer, l);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(l + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        CoinExchange ce =  new CoinExchange();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Collections.reverseOrder()를 사용하려면 배열의 타입을 객채형으로 지정해야한다.
        // ex) int[] => Integer[]
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        ce.dfs(0, 0, arr);
        System.out.println(answer);
    }
}
