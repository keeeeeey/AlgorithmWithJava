package a2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B2660 {

    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j && arr[i][k] != 0 && arr[k][j] != 0) {
                        if (arr[i][j] == 0) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        } else {
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result[i] = Math.max(result[i], arr[i][j]);
            }
            ans = Math.min(ans, result[i]);
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (result[i] == ans) list.add(i);
        }

        list.sort((a, b) -> a - b);
        System.out.print(ans + " ");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
