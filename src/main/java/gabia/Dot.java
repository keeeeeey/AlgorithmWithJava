package gabia;

import java.util.*;

public class Dot {

    public static int dotLength, linesLength;

    public static int[] arr;

    public static int[] ch;

    public static int[] copiedLines;

    public static int answer = Integer.MAX_VALUE;

    public static boolean check(int x) {
        for (int i = 0; i < linesLength; i++) {
            if (ch[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static void cover() {
        int[] copiedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copiedArr[i] = arr[i];
        }

        int cnt = 0;

        for (int i = 0; i < linesLength; i++) {
            if (ch[i] != -1) {
                cnt += 1;
                for (int j = 0; j < copiedArr.length; j++) {
                    if (copiedArr[j] == 1) {
                        for (int k = j; k < j + copiedLines[ch[i]]; k++) {
                            if (k >= copiedArr.length) break;
                            copiedArr[k] = 0;
                        }
                    }
                }
            }
        }

        if (Arrays.stream(copiedArr).sum() == 0) {
            if (answer > cnt) {
                answer = cnt;
            }
        }
    }

    public static void subset(int l) {
        if (l == linesLength) {
            cover();
        } else {
            for (int i = 0; i < linesLength; i++) {
                if (!check(i)) {
                    ch[l] = i;
                    subset(l + 1);
                    ch[l] = -1;
                    subset(l + 1);
                }
            }
        }
    }

    public int solution(int[] dots, int[] lines) {
        copiedLines = lines;
        dotLength = dots.length;
        linesLength = lines.length;

        arr = new int[dots[dotLength - 1] + 1];

        for (int i = 0; i < dotLength; i++) {
            arr[dots[i]] = 1;
        }

        ch = new int[linesLength];

        for (int i = 0; i < linesLength; i++) {
            ch[i] = -1;
        }

        subset(0);
        return answer;
    }

    public static void main(String[] args) {
        Dot dot = new Dot();
        int[] a = {1, 5, 8};
        int[] b = {1, 3, 4, 6};
        dot.solution(a, b);
        System.out.println(answer);
    }
}
