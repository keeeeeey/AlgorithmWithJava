package HashMapTreeSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Anagram {
    public String solution(String strA, String strB) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : strA.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : strB.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            } else {
                map.put(x, map.get(x) - 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        Scanner kb = new Scanner(System.in);
        String strA = kb.next();
        String strB = kb.next();
        System.out.println(anagram.solution(strA, strB));
    }
}
