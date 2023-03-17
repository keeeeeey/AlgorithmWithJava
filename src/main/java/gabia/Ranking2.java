package gabia;

import java.util.LinkedList;

public class Ranking2 {

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

    public static int nameCheck(String name, int K) {
        for (int i = 0; i < K; i++) {
            Score score = list.get(i);
            if (name.equals(score.name)) {
                return i;
            };
        }
        return 101;
    }

    public static int scoreCheck(int score, int K) {
        for (int i = 0; i < K; i++) {
            Score s = list.get(i);
            if (s.score < score) {
                return i;
            };
        }
        return 101;
    }

    private static void insertScore(String name, int score, int nameIdx, int scoreIdx) {
        if (scoreIdx < nameIdx) {
            list.add(scoreIdx, new Score(name, score));
            list.remove(nameIdx + 1);
            answer += 1;
        } else if (scoreIdx == nameIdx) {
            list.add(scoreIdx, new Score(name, score));
            list.remove(nameIdx + 1);
        }
    }

    public static void check(String name, int score, int K) {
        int nameIdx = nameCheck(name, K);
        int scoreIdx = scoreCheck(score, K);

        if (nameIdx == 101) {
            if (scoreIdx == 101) {
                list.add(new Score(name, score));
            } else {
                list.add(scoreIdx, new Score(name, score));
            }
            answer += 1;
        } else {
            insertScore(name, score, nameIdx, scoreIdx);
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
