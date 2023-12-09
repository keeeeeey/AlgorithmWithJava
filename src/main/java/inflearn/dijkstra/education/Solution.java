package inflearn.dijkstra.education;

import java.util.*;

class Solution {
    public String[] solution(String[] subjects, String[] course){
        List<String> temp = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, HashSet<String>> subjectCourse = new HashMap<>();
        HashMap<String, HashSet<String>> subjectNecessary = new HashMap<>();
        for (String c : course) {
            String a = c.split(" ")[0];
            String b = c.split(" ")[1];
            subjectCourse.putIfAbsent(a, new HashSet<>());
            subjectCourse.get(a).add(b);
            subjectNecessary.putIfAbsent(b, new HashSet<>());
            subjectNecessary.get(b).add(a);
        }
        Queue<String> Q = new LinkedList<>();
        for (String subject : subjects) {
            hashMap.put(subject, 0);
            if (!subjectCourse.containsKey(subject)) {
                Q.offer(subject);
                hashMap.put(subject, 1);
                temp.add(subject);
            };
        }

        while (!Q.isEmpty()) {
            String firstSubject = Q.poll();
            if (subjectNecessary.containsKey(firstSubject)) {
                HashSet<String> nextSubject = subjectNecessary.get(firstSubject);
                for (String subject : nextSubject) {
                    if (hashMap.get(subject) == 0 && canListen(subject, subjectCourse, hashMap)) {
                        hashMap.put(subject, 1);
                        temp.add(subject);
                        Q.offer(subject);
                    }
                }
            }
        }

        String[] answer = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }

    private boolean canListen(String subject, HashMap<String, HashSet<String>> subjectCourse, HashMap<String, Integer> hashMap) {
        for (String s : subjectCourse.get(subject)) {
            if (hashMap.get(s) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}