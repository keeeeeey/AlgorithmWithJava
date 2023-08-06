package study.greedy.baekjoon_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zero = 0;
        int one = 0;

        if (S.charAt(0) - '0' == 1) {
            one += 1;
        } else {
            zero += 1;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i) - '0' == 1) {
                    one += 1;
                } else {
                    zero += 1;
                }
            }
        }

        if (zero == 0 || one == 0) {
            System.out.println(0);
        } else {
            System.out.println(Math.min(zero, one));
        }
    }
}
