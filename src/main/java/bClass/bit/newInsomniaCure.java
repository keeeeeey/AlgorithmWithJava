package bClass.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class newInsomniaCure {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] visited = new int[10];
            int answer = 0;
            while (true) {
                answer += 1;
                char[] arr = String.valueOf(answer * N).toCharArray();
                for (char c : arr) {
                    int num = Character.getNumericValue(c);
                    if (visited[num] == 0) {
                        visited[num] = 1;
                    }
                }
                if (Arrays.stream(visited).sum() == 10) break;
            }

            System.out.println("#" + i + " " + N * answer);
        }
    }
}
