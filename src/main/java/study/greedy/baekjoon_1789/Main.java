package study.greedy.baekjoon_1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        System.out.println(solution(S));
    }

    private static int solution(long S) {
        long sum = 0;
        int answer = 0;
        for (int i = 1; ; i++) {
            if (sum > S) break;
            answer += 1;
            sum += i;
        }
        return answer - 1;
    }
}
