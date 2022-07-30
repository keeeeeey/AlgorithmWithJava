package array;

import java.util.Scanner;

public class CalPoint {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CalPoint cp = new CalPoint();
        Scanner kp = new Scanner(System.in);
        int n = kp.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kp.nextInt();
        }
        System.out.println(cp.solution(n, arr));
    }
}
