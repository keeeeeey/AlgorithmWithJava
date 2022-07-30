package string;

import java.util.Scanner;

public class OnlyNumber {
    public int solution(String s) {
//        int answer = 0;
//        for (char x : s.toCharArray()) {
//            if (x >= 48 && x <= 57) {
//                answer = answer * 10 + (x - 48);
//            }
//        }
        String answer = "";
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        OnlyNumber on = new OnlyNumber();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(on.solution(str));
    }
}
