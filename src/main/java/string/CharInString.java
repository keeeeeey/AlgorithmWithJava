package string;

import java.util.Scanner;

public class CharInString {
    public String solution(String str) {
        String answer = "";
//        int m = Integer.MIN_VALUE;
//        String[] s = str.split(" ");
//        for (String x : s) {
//            int len = x.length();
//            if (len > m) {
//                m = len;
//                answer = x;
//            }
//        }

        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        CharInString cis = new CharInString();
        Scanner kb = new Scanner(System.in);
        // 문자열 받기
        String str = kb.nextLine();

        System.out.print(cis.solution(str));
    }
}
