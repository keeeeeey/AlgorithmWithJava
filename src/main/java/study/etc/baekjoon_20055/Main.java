package study.etc.baekjoon_20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;

    public static int N, K;

    public static Deque<Integer> arr = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr.addLast(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution());
    }

    private static int solution() {


    }
}
