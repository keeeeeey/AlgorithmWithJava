package study.divide.baekjoon_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lessonList = new int[N];

        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lessonList[i] = Integer.parseInt(st.nextToken());
            right += lessonList[i];
            left = Math.max(left, lessonList[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = count(N, mid, lessonList);

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    private static int count(int N, int mid, int[] lessonList) {
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + lessonList[i] > mid) {
                cnt += 1;
                sum = 0;
            }
            sum += lessonList[i];
        }

        if (sum != 0) {
            cnt += 1;
        }
        return cnt;
    }
}
