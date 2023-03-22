package baekjoon2Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubTotal {

    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int minLength = Integer.MAX_VALUE;

        if (arr[0] >= S) {
            minLength = 1;
        } else {
            int temp = arr[0] + arr[1];

            while (true) {
                if (temp >= S) {
                    int tempLength = right - left + 1;
                    if (tempLength < minLength) {
                        minLength = tempLength;
                    }
                    temp -= arr[left];
                    left += 1;
                } else {
                    right += 1;
                    if (right >= N) break;
                    temp += arr[right];
                }
            }
        }


        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}
