package olive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Stock {

    public static void main(String[] args) {
        String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
        String[] usa = {"AB", "AA", "TTTT"};

        System.out.println(usa.length);
        System.out.println(kor[0].length());
        String test = "123 456 789";
        String[] split = test.split(" ");
        System.out.println(Arrays.toString(split));

        List<String> stringList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", hashMap.getOrDefault("1", 0) + 1);

        for (String str : hashMap.keySet()) {

        }
    }
}
