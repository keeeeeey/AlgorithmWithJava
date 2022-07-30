package string;

import java.util.Scanner;

public class Password {
    public String solution(int n, String str) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String temp = str.substring(0, 7).replace("#", "1").replace("*", "0");
            int num = Integer.parseInt(temp, 2);
            answer += (char) num;
            str = str.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {
        Password pw = new Password();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        // 문자열 받기
        String str = kb.next();

        System.out.print(pw.solution(n, str));
    }
}
