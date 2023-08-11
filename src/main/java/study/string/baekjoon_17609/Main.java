package study.string.baekjoon_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            solution(str);
        }
        System.out.println(sb);
    }

    private static void solution(String str) {
        int left = 0;
        int right = str.length() - 1;
        int check = 0;
        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left += 1;
                right -= 1;
            } else {
                check += 1;
                if (!isSame(left + 1, right, str) && !isSame(left, right - 1, str)) {
                    check += 1;
                }
                break;
            }
        }
        sb.append(check).append("\n");
    }

    private static boolean isSame(int left, int right, String str) {
        int leftTemp = left;
        int rightTemp = right;
        while (leftTemp <= rightTemp) {
            if (str.charAt(leftTemp) != str.charAt(rightTemp)) {
                return false;
            }
            leftTemp += 1;
            rightTemp -= 1;
        }
        return true;
    }
}
