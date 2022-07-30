package string;

import java.util.Scanner;

public class PalindromeReplaceAll {
    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String temp = new StringBuilder(str).reverse().toString();
        if (str.equals(temp)) {
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        PalindromeReplaceAll pdra = new PalindromeReplaceAll();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(pdra.solution(str));
    }
}
