package gabia;

import java.util.LinkedList;

public class Ranking {

    public static class Score {
        String name;
        int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static LinkedList<Score> list = new LinkedList<>();

    public static int answer = 0;

    public static void check(String name, int score, int K) {

        int nameIdx = 101;
        int scoreIdx = 101;

        for (int i = 0; i < K; i++) {
            Score s = list.get(i);
            String beforeName = s.name;
            int beforeScore = s.score;

            if (beforeName.equals(name)) {
                nameIdx = i;
            }

            if (score > beforeScore && scoreIdx > i) {
                scoreIdx = i;
            }
        }

        if (scoreIdx != 101) {
            if (nameIdx != 101) {
                list.remove(nameIdx);
                list.add(scoreIdx, new Score(name, score));
            } else {
                list.add(scoreIdx, new Score(name, score));
            }
            answer += 1;
        }
    }

    public int solution(int K, String[] user_scores) {
        for (String str : user_scores) {
            String[] strArr = str.split(" ");
            String name = strArr[0];
            int score = Integer.parseInt(strArr[1]);

            if (list.size() == 0) {
                list.add(new Score(name, score));
                answer += 1;
            } else if (list.size() < K) {
                check(name, score, list.size());
            } else {
                check(name, score, K);
            }
        }
        return answer;
    }
}
