package string;

import java.util.Scanner;

public class StringCompression {
    public String solution(String str) {
        String answer = "";
        str = str + " ";
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i ++) {
             if (str.charAt(i) == str.charAt(i + 1)) {
                 cnt++;
             } else {
                 answer += str.charAt(i);
                 if (cnt > 1) {
                     answer += String.valueOf(cnt);
//                     answer += Integer.toString(cnt);
                     cnt = 1;
                 }
             }
        }
        return answer;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        Scanner kb = new Scanner(System.in);
        // 문자열 받기
        String str = kb.next();

        System.out.print(sc.solution(str));
    }
}
