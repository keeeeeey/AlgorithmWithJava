package HashMapTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagram {
    public int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char x : t.toCharArray()) {
            mapT.put(x, mapT.getOrDefault(x, 0) + 1);
        }
        int L = t.length() - 1;
        for (int i = 0; i < L; i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        int lt = 0;
        for (int rt = L; rt < s.length(); rt++) {
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt), 0) + 1);
            if (mapS.equals(mapT)) {
                answer++;
            }
            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) - 1);
            if (mapS.get(s.charAt(lt)) == 0) {
                mapS.remove(s.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindAllAnagram faa = new FindAllAnagram();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        String t = kb.next();
        System.out.println(faa.solution(s, t));
    }
}
