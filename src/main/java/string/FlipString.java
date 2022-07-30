package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipString {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
//            String temp = new StringBuilder(x).reverse().toString();
//            answer.add(temp);
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while (lt < rt) {
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;
                lt++;
                rt--;
            }
            String temp = String.valueOf(s);
            answer.add(temp);
        }
        return answer;
    }

    public static void main(String[] args) {
        FlipString fs = new FlipString();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String x : fs.solution(n, str)) {
            System.out.println(x);
        }

    }
}
