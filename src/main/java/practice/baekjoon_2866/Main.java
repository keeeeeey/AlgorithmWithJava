package practice.baekjoon_2866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        System.out.println(solution(R, C, arr));
    }

    private static int solution(int R, int C, char[][] arr) {
        int answer = 0;
        int top = 0;
        int bottom = R - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            boolean isDuplicate = checkString(R, C, arr, mid);

            if (isDuplicate) {
                bottom = mid - 1;
            } else {
                answer = mid;
                top = mid + 1;
            }
        }

        return answer;
    }

    private static boolean checkString(int R, int C, char[][] arr, int mid) {
        HashMap<String, Integer> checkMap = new HashMap<>();
        for (int i = 0; i < C; i++) {
            String temp = "";
            for (int j = mid; j < R; j++) {
                temp += arr[j][i];
            }
            if (checkMap.containsKey(temp)) {
                return true;
            } else {
                checkMap.put(temp, 0);
            }
        }
        return false;
    }
}
