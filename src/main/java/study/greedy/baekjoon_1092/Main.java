package study.greedy.baekjoon_1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> limit = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            limit.add(Integer.parseInt(st.nextToken()));
        }
        limit.sort(Comparator.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxList.add(Integer.parseInt(st.nextToken()));
        }
        boxList.sort(Comparator.reverseOrder());

        if (limit.get(0) < boxList.get(0)) {
            System.out.println(-1);
        } else {
            System.out.println(solution(N, limit, boxList));
        }
    }

    private static int solution(int N, List<Integer> limit, List<Integer> boxList) {
        int answer = 0;
        while (!boxList.isEmpty()) {
            answer += 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < boxList.size(); j++) {
                    if (limit.get(i) >= boxList.get(j)) {
                        boxList.remove(j);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
