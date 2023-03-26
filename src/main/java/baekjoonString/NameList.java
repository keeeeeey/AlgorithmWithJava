package baekjoonString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NameList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
            if (hashMap.get(name) == 2) {
                list.add(name);
            }
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
