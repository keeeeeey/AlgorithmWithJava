package practice.baekjoon_3649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            if (n == 0 || n == 1) {
                System.out.println("danger");
            } else {
                System.out.println(solution(x, n, arr));
            }
        }
    }

    private static String solution(int x, int n, int[] arr) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int temp = arr[left] + arr[right];

            if (temp == x) {
                return "yes " + arr[left] + " " + arr[right];
            } else if (temp < x) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return "danger";
    }
}
