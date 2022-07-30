package twoPointersSlidingWindow;

import java.util.Scanner;

public class SumContinuousNaturalNumberMath {
    public int solution(int n) {
        int answer = 0, cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SumContinuousNaturalNumberMath scnn = new SumContinuousNaturalNumberMath();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(scnn.solution(n));
    }
}
