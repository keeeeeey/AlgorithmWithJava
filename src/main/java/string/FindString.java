package string;

import java.util.Scanner;

public class FindString {
    public int solution(String str, char t) {
        int answer = 0;
        // 문자열 대문자로 변경
        str = str.toUpperCase();
        // 타겟 문자 대문자로 변경
        t = Character.toUpperCase(t);

        // str 문자열 탐색
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == t) {
//                answer++;
//            }
//        }

        // 향상된 for 문
        for (char x : str.toCharArray()) {
            if (x == t) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FindString fs = new FindString();
        Scanner kb = new Scanner(System.in);
        // 문자열 받기
        String str = kb.next();
        // 탐색할 타셋 문자 받기
        char c = kb.next().charAt(0);
        System.out.print(fs.solution(str, c));
    }
}
