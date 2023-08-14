package study.divide.baekjoon_1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = (Y * 100) / X;

        int answer = -1;
        int left = 0;
        int right = (int) 1e9;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (((Y + mid) * 100 / (X + mid)) != Z) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
