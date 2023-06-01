package study.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StartAndLink {

    public static int N, cnt;

    public static int[][] arr;

    public static int[] ch;

    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ch = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
        System.out.println(answer);
    }

    private static void solution(int l) {
        if (l == N) {
            if (cnt != N / 2) return;
            divide();
        } else {
            ch[l] = 1;
            cnt += 1;
            solution(l + 1);
            ch[l] = 0;
            cnt -= 1;
            solution(l + 1);
        }
    }

    private static void divide() {
        List<Integer> start = new ArrayList<>();
        List<Integer> link = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (ch[i] == 1) {
                start.add(i);
            } else {
                link.add(i);
            }
        }

        compare(start, link);
    }

    private static void compare(List<Integer> start, List<Integer> link) {
        int startPoint = 0;
        int linkPoint = 0;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                startPoint += arr[start.get(i)][start.get(j)] + arr[start.get(j)][start.get(i)];
                linkPoint += arr[link.get(i)][link.get(j)] + arr[link.get(j)][link.get(i)];
            }
        }

        answer = Math.min(answer, Math.abs(startPoint - linkPoint));
    }
}