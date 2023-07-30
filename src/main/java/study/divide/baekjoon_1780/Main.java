package study.divide.baekjoon_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static HashMap<Integer, Integer> answerMap = new HashMap<>();

    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answerMap.put(-1, 0);
        answerMap.put(0, 0);
        answerMap.put(1, 0);

        divide(0, 0, N);

        System.out.println(answerMap.get(-1));
        System.out.println(answerMap.get(0));
        System.out.println(answerMap.get(1));
    }

    private static void divide(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            answerMap.put(arr[row][col], answerMap.get(arr[row][col]) + 1);
            return;
        }

        int newSize = size / 3;

        divide(row, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row, col + 2 * newSize, newSize);

        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
        divide(row + newSize, col + 2 * newSize, newSize);

        divide(row + 2 * newSize, col, newSize);
        divide(row + 2 * newSize, col + newSize, newSize);
        divide(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    private static boolean colorCheck(int x, int y, int size) {
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
