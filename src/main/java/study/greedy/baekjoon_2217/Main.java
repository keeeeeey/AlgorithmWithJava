package study.greedy.baekjoon_2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> roapList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            roapList.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(solution(N, roapList));
    }

    private static int solution(int N, List<Integer> roapList) {
        roapList.sort(Comparator.reverseOrder());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, roapList.get(i) * (i + 1));
        }
        return answer;
    }
}
