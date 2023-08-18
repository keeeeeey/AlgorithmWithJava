package study.string.baekjoon_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static HashSet<String> hashSet;

    public static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String anagram = br.readLine();
            solution(anagram);
        }
        System.out.println(sb);
    }

    private static void solution(String anagram) {
        char[] anaArr = anagram.toCharArray();
        Arrays.sort(anaArr);
        hashSet = new HashSet<>();
        check = new int[anaArr.length];
        Arrays.fill(check, -1);
        backtracking(0, anaArr);
    }

    private static void backtracking(int i, char[] anaArr) {
        if (i == anaArr.length) {
            String answer = "";
            for (int idx : check) {
                answer += anaArr[idx];
            }

            if (hashSet.contains(answer)) return;

            hashSet.add(answer);
            sb.append(answer).append("\n");
            return;
        }

        for (int c = 0; c < anaArr.length; c++) {
            if (check[i] == -1 && !hasC(c)) {
                check[i] = c;
                backtracking(i + 1, anaArr);
                check[i] = -1;
            }
        }
    }

    private static boolean hasC(int c) {
        for (int idx : check) {
            if (idx == c) return true;
        }
        return false;
    }


}
