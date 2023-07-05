package study.recursive.baekjoon_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int white, blue;

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

        solution(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void solution(int size, int row, int col) {
        if (colorCheck(size, row, col)) {
            if (arr[row][col] == 0) {
                white += 1;
            } else {
                blue += 1;
            }
            return;
        }

        int newSize = size / 2;

        solution(newSize, row, col);
        solution(newSize, row + newSize, col);
        solution(newSize, row, col + newSize);
        solution(newSize, row + newSize, col + newSize);
    }

    public static boolean colorCheck(int size, int row, int col) {

        int color = arr[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(arr[i][j] != color) return false;
            }
        }

        return true;
    }
}
