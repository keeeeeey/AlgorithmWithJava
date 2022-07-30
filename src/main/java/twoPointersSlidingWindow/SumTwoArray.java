package twoPointersSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class SumTwoArray {
    public ArrayList<Integer> solution(int n, int[] arrN, int m, int[] arrM) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arrN[p1] < arrM[p2]) {
                answer.add(arrN[p1++]);
            } else {
                answer.add(arrM[p2++]);
            }
        }
        while (p1 < n) {
            answer.add(arrN[p1++]);
        }
        while (p2 < m) {
            answer.add(arrM[p2++]);
        }
        return answer;
    }

    public static void main(String[] args) {
        SumTwoArray sta = new SumTwoArray();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = kb.nextInt();
        }
        for (int x : sta.solution(n, arrN, m, arrM)) {
            System.out.print(x + " ");
        }
    }

}
