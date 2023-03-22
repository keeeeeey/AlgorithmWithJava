package baekjoon2Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoWater {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N - 1;
        int minValue = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = N - 1;
        while (left < right) {
            int temp = arr[left] + arr[right];

            if (Math.abs(temp) <= minValue) {
                minValue = Math.abs(temp);
                minLeft = left;
                minRight = right;
            }

            if (temp < 0) {
                left += 1;
            } else if (temp > 0) {
                right -= 1;
            } else {
                break;
            }
        }
        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}
