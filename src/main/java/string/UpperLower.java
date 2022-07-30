package string;

import java.util.Scanner;

public class UpperLower {
    public String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
//            if (Character.isLowerCase(c)) {
//                answer += Character.toUpperCase(c);
//            } else {
//                answer += Character.toLowerCase(c);
//            }
            if (c >= 97 && c <= 122) {
                answer += (char)(c - 32);
            } else {
                answer += (char)(c + 32);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        UpperLower ul = new UpperLower();
        Scanner kb = new Scanner(System.in);
        // 문자열 받기
        String str = kb.next();

        System.out.print(ul.solution(str));
    }
}
