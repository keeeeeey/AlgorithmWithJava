package bClass.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Code3 {

    public static List<Integer> list;

    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                char cmd = st.nextToken().charAt(0);
                int x = Integer.parseInt(st.nextToken());
                func(cmd, x);
            }

            System.out.print("#" + tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
    }

    public static void func(char cmd, int x) {
        int y = 0;
        if (cmd == 'I') {
            y = Integer.parseInt(st.nextToken());
            for (int i = 0; i < y; i++) {
                list.add(x, Integer.parseInt(st.nextToken()));
                x++;
            }
        } else if (cmd == 'D') {
            y = Integer.parseInt(st.nextToken());
            for (int i = 0; i < y; i++) {
                list.remove(x);
            }
        } else {
            for (int i = 0; i < x; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
