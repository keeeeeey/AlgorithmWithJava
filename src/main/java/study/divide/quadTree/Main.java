package study.divide.quadTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;

    public static String answer = "";

    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(solution(0, 0, N));
    }

    private static String solution(int x, int y, int size) {

        if (isPossible(x, y, size)) {
            return answer += arr[x][y];
        }

        int newSize = size / 2;

        answer += "(";

        solution(x, y, newSize);
        solution(x, y + newSize, newSize);
        solution(x + newSize, y, newSize);
        solution(x + newSize, y + newSize, newSize);

        return answer += ")";
    }

    private static boolean isPossible(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
