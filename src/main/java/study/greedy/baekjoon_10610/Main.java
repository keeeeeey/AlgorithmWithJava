package study.greedy.baekjoon_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int sum = 0;
        boolean flag = false;
        Integer[] arr = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            arr[i] = N.charAt(i) - '0';
            sum += arr[i];
            if (arr[i] == 0) {
                flag = true;
            }
        }

        if (flag && sum % 3 == 0) {
            Arrays.sort(arr, Comparator.reverseOrder());
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < N.length(); i++) {
                answer.append(arr[i]);
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
