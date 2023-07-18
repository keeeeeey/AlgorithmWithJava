package toss.toss_4;

import java.util.*;

public class Solution {

    public static Queue<Integer> recent = new LinkedList<>();

    public static Stack<Integer> back = new Stack<>();

    public static Stack<Integer> forward = new Stack<>();

    public String[] solution(int maxSize, String[] actions) {
        String[] answer = new String[maxSize];

        for (String action : actions) {
            if (isNumeric(action)) {
                if (!recent.isEmpty()) {
                    back.add(recent.peek());
                }
                recent.offer(Integer.parseInt(action));
            } else {
                if (action.equals("B")) {
                    if (!back.isEmpty()) {
                        forward.add(recent.peek());
                        recent.offer(back.pop());
                    }
                } else {
                    if (!forward.isEmpty()) {
                        back.add(recent.peek());
                        recent.offer(forward.pop());
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isNumeric(String action) {
        if (action == null) {
            return false;
        }

        try {
            Integer d = Integer.parseInt(action);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}