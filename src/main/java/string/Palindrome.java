package string;

import java.util.Locale;
import java.util.Scanner;

public class Palindrome {
    public String solution(String str) {
        String answer = "YES";
//        str = str.toUpperCase();
//        int len = str.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i) != str.charAt(len - i - 1)) {
//                answer = "NO";
//            }
//        }
        String temp = new StringBuilder(str).reverse().toString();
        if (!str.equalsIgnoreCase(temp)) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Palindrome pd = new Palindrome();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(pd.solution(str));
    }
}
