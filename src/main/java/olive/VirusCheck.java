package olive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VirusCheck {

    public static void main(String[] args) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        hashMap.put("a", new ArrayList<>());
        hashMap.get("a").add("abc");
        hashMap.get("a").add("def");
        List<String> stringList = hashMap.get("a");
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        System.out.println(hashMap.get("a").contains("abc"));
        String temp = "abc123";
        String answer = "";
        for (char c : temp.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        System.out.println(Integer.parseInt(answer) + 123);


        HashMap<String, List<String[]>> hashMap2 = new HashMap<>();
        hashMap2.put("a", new ArrayList<>());
        hashMap2.get("a").add(new String[]{"a", "b"});
    }
}
