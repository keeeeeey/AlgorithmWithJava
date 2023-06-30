package study.programmers.kakao2023_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static String[] todayArr;

    public static HashMap<String, Integer> termsMap = new HashMap<>();

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();

        todayArr = today.split("\\.");

        for (String term : terms) {
            String[] temp = term.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int limit = termsMap.get(privacy[1]) * 28;
            String[] privacyDate = privacy[0].split("\\.");

            int diff = (Integer.parseInt(todayArr[0]) - Integer.parseInt(privacyDate[0])) * 28 * 12
                    + (Integer.parseInt(todayArr[1]) - Integer.parseInt(privacyDate[1])) * 28
                    + (Integer.parseInt(todayArr[2]) - Integer.parseInt(privacyDate[2]));

            if (diff >= limit) {
                answerList.add(i + 1);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }
}