package street11;

import java.util.HashMap;

public class Problem1 {

    public int solution(String S) {
        // Implement your solution here
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : S.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) % 2 == 1) {
                answer += 1;
            }
        }

        return answer;
    }
}
