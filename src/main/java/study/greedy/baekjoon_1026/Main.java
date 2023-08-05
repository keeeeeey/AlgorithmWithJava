package study.greedy.baekjoon_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        Integer[] arrB = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arrA, arrB));
    }

    private static int solution(int N, int[] arrA, Integer[] arrB) {
        int answer = 0;
        Arrays.sort(arrA);
        Arrays.sort(arrB, Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            answer += arrA[i] * arrB[i];
        }
        return answer;
    }
}
