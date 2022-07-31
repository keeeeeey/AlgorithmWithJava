package stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public String solution(String str1, String str2) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str1.length(); i++) {
            queue.offer(str1.charAt(i));
        }
        for (char x : str2.toCharArray()) {
            if (queue.contains(x)) {
                if (queue.poll() != x) {
                    answer = "NO";
                    return answer;
                }
            }
        }
        if (!queue.isEmpty()) {
            answer = "NO";
            return answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        CurriculumDesign cd = new CurriculumDesign();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(cd.solution(str1, str2));
    }
}
