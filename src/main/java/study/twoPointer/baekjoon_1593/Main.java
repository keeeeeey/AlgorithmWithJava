package study.twoPointer.baekjoon_1593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int g, s;

    public static String W, S;

    public static HashMap<Character, Integer> mapW = new HashMap<>();

    public static HashMap<Character, Integer> check = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        W = br.readLine();
        S = br.readLine();

        // cAda mapW c: 1, A : 1, d : 1, a : 1
        // AbrAcadAbRa
        // check c : 0 , A : 0,
        for (int i = 0; i < g; i++) {
            mapW.put(W.charAt(i), mapW.getOrDefault(W.charAt(i), 0) + 1);
            check.put(W.charAt(i), 0);
        }

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < s; i++) {
            if (i >= g) {
                if (check.containsKey(S.charAt(i - g))) {
                    cnt -= 1;
                    check.put(S.charAt(i - g), check.get(S.charAt(i - g)) - 1);
                }
            }

            if (check.containsKey(S.charAt(i))) {
                cnt += 1;
                check.put(S.charAt(i), check.get(S.charAt(i)) + 1);
            }

            if (cnt == g) {
                boolean flag = true;
                for (char c : check.keySet()) {
                    if (check.get(c) != mapW.get(c)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
