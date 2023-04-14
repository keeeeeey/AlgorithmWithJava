package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Schedule {

    public static class Lecture implements Comparable<Lecture> {
        public int money;
        public int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture l) {
            return l.time - this.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Lecture> arr = new ArrayList<>();
        int maxDate = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr.add(new Lecture(money, time));
            if (time > maxDate) {
                maxDate = time;
            }
        }

        arr.sort(Comparator.naturalOrder());

        PriorityQueue<Lecture> pq = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture l1, Lecture l2) {
                return l2.money - l1.money;
            }
        });

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (arr.get(i).time < maxDate) {
                Lecture lecture = pq.poll();
                answer += lecture.money;
                maxDate = arr.get(i).time;
            }
            pq.add(arr.get(i));
        }
        answer += pq.poll().money;
        System.out.println(answer);
    }
}
