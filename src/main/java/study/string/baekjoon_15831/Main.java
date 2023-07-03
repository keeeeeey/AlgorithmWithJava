package study.string.baekjoon_15831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, B, W;

    public static String rock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        rock = br.readLine();
        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;
        int left = 0;
        int right = 0;
        int wCnt = 0;
        int bCnt = 0;

        while (right < N) {
            if (bCnt > B) {
                if (rock.charAt(left) == 'W') {
                    wCnt -= 1;
                } else {
                    bCnt -= 1;
                }
                left += 1;
            } else {
                if (rock.charAt(right) == 'W') {
                    wCnt += 1;
                } else {
                    bCnt += 1;
                }
                right += 1;
            }

            if (wCnt >= W && bCnt <= B) {
                answer = Math.max(answer, wCnt + bCnt);
            }
        }
        return answer;
    }
}
