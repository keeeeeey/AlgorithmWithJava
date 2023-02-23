package baekjoonSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PointSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            List<Integer> point = new ArrayList<>();
            point.add(x);
            point.add(y);
            list.add(point);
        }

        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) > o2.get(0)) {
                    return o1.get(0) - o2.get(0);
                } else if (Objects.equals(o1.get(0), o2.get(0))) {
                    return o1.get(1) - o2.get(1);
                }
                return -1;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
        }
    }
}
