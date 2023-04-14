package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Wedding {

    public static class Time implements Comparable<Time>{
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time t) {
            if (this.time == t.time) {
                return this.state - t.state;
            }
            return this.time - t.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Time> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            arr.add(new Time(startTime, 's'));
            arr.add(new Time(endTime, 'e'));
        }

        int answer = Integer.MIN_VALUE;

        arr.sort(Comparator.naturalOrder());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr.get(i).state == 's') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
