package baekjoonPq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_23254 {

    static int n; // 시간
    static int m; // 과목
    static int[] basic; // 기본 점수
    static PriorityQueue<growth> growths; // 성장률

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()) * 24;
        m = Integer.parseInt(st.nextToken());

        basic = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            basic[i] = Integer.parseInt(st.nextToken());
        }

        growths = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            growths.add(new growth(i, number));
        }

        while(n > 0 && !growths.isEmpty()) {
            growth p = growths.poll();
            int time = ((100 - basic[p.id]) / p.number);
            int realTime = Math.min(n, time);

            n -= realTime;
            basic[p.id] += p.number * realTime;

            if(basic[p.id] != 100) {
                growths.add(new growth(p.id, 100 - basic[p.id]));
            }

        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer += basic[i];
        }

        System.out.println(answer);

    }


    // 성장률 내림차순
    public static class growth implements Comparable<growth> {
        int id;
        int number;

        growth(int id, int number) {
            this.id = id;
            this.number = number;
        }

        public int compareTo(growth g) {
            return g.number - this.number;
        }

    }

}
