package baekjoonSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortInside {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        List<Integer> list = new ArrayList<>();

        for (char c : N.toCharArray()) {
            list.add(c - '0');
        }

        Collections.sort(list, (x1, x2) -> {
            return x2 - x1;
        });

        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}
