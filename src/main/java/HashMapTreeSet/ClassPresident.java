package HashMapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // HashMap에 해당 키가 존재하는지 확인 true, false 반환
        System.out.println(map.containsKey('A')); // true

        // 키의 개수를 알려준다.
        System.out.println(map.size()); // 5

        // 특정 키를 삭제
        System.out.println(map.remove('A')); // A의 개수 3을 리턴
        System.out.println(map.size()); // 4

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ClassPresident cp = new ClassPresident();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(cp.solution(n, str));
    }
}
