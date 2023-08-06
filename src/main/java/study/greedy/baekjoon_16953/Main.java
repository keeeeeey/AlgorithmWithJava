package study.greedy.baekjoon_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 0;
        boolean flag = true;
        while (true) {
            if (A == B) {
                break;
            } else if (A > B) {
                flag = false;
                break;
            }
            answer += 1;

            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(answer + 1);
        } else {
            System.out.println(-1);
        }
    }
}
