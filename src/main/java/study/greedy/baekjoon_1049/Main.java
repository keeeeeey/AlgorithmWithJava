package study.greedy.baekjoon_1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrSet = new int[M];
        int[] arrSingle = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arrSet[i] = Integer.parseInt(st.nextToken());
            arrSingle[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrSet);
        Arrays.sort(arrSingle);

        if (arrSet[0] > arrSingle[0] * 6) {
            System.out.println(arrSingle[0] * N);
        } else {
            if (N % 6 == 0) {
                System.out.println(arrSet[0] * (N / 6));
            } else {
                System.out.println(Math.min(arrSet[0] *(N / 6 + 1), arrSet[0] * (N / 6) + arrSingle[0] * (N % 6)));
            }
        }
    }
}
