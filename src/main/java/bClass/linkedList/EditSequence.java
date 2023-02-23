package bClass.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EditSequence {

    public static List<Integer> list;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());
                func(cmd, x);
            }

            if (list.size() <= L) {
                System.out.println("#" + tc + " -1");
            } else {
                System.out.println("#" + tc + " " + list.get(L));
            }
        }
    }

    public static void func(char cmd, int x) {
        if (cmd == 'I') {
            list.add(x, Integer.parseInt(st.nextToken()));
        } else if (cmd == 'D') {
            list.remove(x);
        } else {
            list.remove(x);
            list.add(x, Integer.parseInt(st.nextToken()));
        }
    }
}
