package study.greedy.baekjoon_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] scoreArr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                scoreArr[i][0] = A;
                scoreArr[i][1] = B;
            }
            System.out.println(solution(N, scoreArr));
        }
    }

    private static int solution(int N, int[][] scoreArr) {
        Arrays.sort(scoreArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int answer = 1;
        int minValue = scoreArr[0][1];

        for (int i = 0; i < N; i++) {
            if (minValue > scoreArr[i][1]) {
                answer += 1;
                minValue = scoreArr[i][1];
            }
        }

        return answer;
    }
}
