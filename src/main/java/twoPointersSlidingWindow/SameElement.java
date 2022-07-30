package twoPointersSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SameElement {
    public ArrayList<Integer> solution(int n, int[] arrN, int m, int[] arrM) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arrN);
        Arrays.sort(arrM);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arrN[p1] == arrM[p2]) {
                answer.add(arrN[p1++]);
                p2++;
            } else if (arrN[p1] > arrM[p2]) {
                p2++;
            } else {
                p1++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SameElement se = new SameElement();
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
        for (int x : se.solution(n, arrN, m, arrM)) {
            System.out.print(x + " ");
        }
    }
}
