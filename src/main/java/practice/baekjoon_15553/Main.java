package practice.baekjoon_15553;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> T = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            T.add(Integer.parseInt(br.readLine()));
        }

        List<int[]> bt = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            bt.add(new int[]{T.get(i) - T.get(i - 1), i});
        }
        bt.sort((a, b) -> b[0] - a[0]);

        int[] stop = new int[N];
        for (int i = 1; i < K; i++) {
            stop[bt.get(i - 1)[1]] = 1;
        }

        int answer = 0;
        int now = 0;
        for (int i = 1; i < N; i++) {
            if (stop[i] == 1) {
                answer += T.get(i - 1) - T.get(now) + 1;
                now = i;
            }
        }
        answer += T.get(N - 1) - T.get(now) + 1;
        System.out.println(answer);
    }
}
