package inflearn.hashingandparsing.stringUsingOne;

import java.util.HashMap;

class Solution {
    public int solution(String s){
//        int answer = 0;
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        for (char key : s.toCharArray()) {
//            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (hashMap.get(s.charAt(i)) == 1) {
//                answer = i + 1;
//                break;
//            }
//        }
//        if (answer == 0) return -1;
//        return answer;

        HashMap<Character, Integer> sH = new HashMap<>();
        for (char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (sH.get(s.charAt(i)) == 1) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}