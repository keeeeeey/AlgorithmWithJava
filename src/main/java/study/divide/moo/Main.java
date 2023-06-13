package study.divide.moo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Character answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        solution(N);
        System.out.println(answer);
    }

    public static void solution(int N) {
        int size = 3;
        int cnt = 0;

        while (size < N) {
            cnt += 1;
            size = size * 2 + cnt + 3;
        }

        int front_back = (size - cnt - 3) / 2;

        if (size - front_back + 1 <= N) {
            solution(N - size + front_back);
        } else if (N == front_back + 1) {
            answer = 'm';
        } else {
            answer = 'o';
        }
    }
}
