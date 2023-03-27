package baekjoonString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TailString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new ArrayList<>();
        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            temp = str.charAt(i) + temp;
            list.add(temp);
        }
        list.sort(Comparator.naturalOrder());

        list.forEach(System.out::println);
    }
}
