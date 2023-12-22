package practice.baekjoon_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static HashMap<String, Integer> strMap;
    public static int[] ch;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            String str = br.readLine();
            strMap = new HashMap<>();
            ch = new int[26];
            for (int i = 0; i < str.length(); i++) {
                ch[str.charAt(i) - 97] += 1;
            }
            solution(str);
        }
    }

    private static void solution(String str) {
        int len = str.length();
        comb(0, len);
        List<String> answerList = new ArrayList<>(strMap.keySet());
        answerList.sort(Comparator.naturalOrder());
        for (String s : answerList) {
            System.out.println(s);
        }
    }

    private static void comb(int l, int len) {
        if (l == len) {
            String temp = "";
            for (char c : stack) {
                temp += c;
            }

            if (!strMap.containsKey(temp)) {
                strMap.put(temp, 1);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (ch[i] > 0) {
                    ch[i] -= 1;
                    stack.add((char) (i + 97));
                    comb(l + 1, len);
                    ch[i] += 1;
                    stack.pop();
                }
            }
        }
    }
}
