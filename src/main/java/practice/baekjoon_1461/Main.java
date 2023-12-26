package practice.baekjoon_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int bookIdx = Integer.parseInt(st.nextToken());
            int bookIdxAbs = Math.abs(bookIdx);
            if (bookIdx > 0) {
                plus.add(bookIdx);
            } else {
                minus.add(bookIdxAbs);
            }
            max = Math.max(max, bookIdxAbs);
        }

        plus.sort(Comparator.reverseOrder());
        minus.sort(Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < plus.size(); i++) {
            if (i % M == 0 && plus.get(i) == max) {
                answer += plus.get(i);
            } else if (i % M == 0) {
                answer += plus.get(i) * 2;
            }
        }

        for (int i = 0; i < minus.size(); i++) {
            if (i % M == 0 && minus.get(i) == max) {
                answer += minus.get(i);
            } else if (i % M == 0) {
                answer += minus.get(i) * 2;
            }
        }
        System.out.println(answer);
    }
}
