package study.string.baekjoon_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static int n;

    public static List<String> list;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            list = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String number = br.readLine();
                list.add(number);
            }
            list.sort(Comparator.naturalOrder());

            sb.append(solution()).append("\n");
        }
        System.out.println(sb);
    }

    private static String solution() {
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i + 1).startsWith(list.get(i))) {
                return "NO";
            }
        }
        return "YES";
    }
}
