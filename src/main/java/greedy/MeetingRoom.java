package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class MeetingRoom {

    public static class MeetingTime implements Comparable<MeetingTime> {
        int start;
        int end;

        public MeetingTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingTime mr) {
            if (this.end == mr.end) {
                return this.start - mr.start;
            }
            return this.end - mr.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<MeetingTime> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new MeetingTime(start, end));
        }

        arr.sort(Comparator.naturalOrder());
        int answer = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if (arr.get(i).start >= endTime) {
                endTime = arr.get(i).end;
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
