package baekjoonPq;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class shoppingMall {

    static long N, K;
    static long answer = 0, answerI = 1;
    static PriorityQueue<Calc> calcQ = new PriorityQueue<>();
    // 큐 하나로 관리하면 둘 이상의 계산대에서 빠져나갈 때 계산대 번호가 높은 곳부터 들어가게 됨
    static PriorityQueue<Out> outQ = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(i < K) {
                calcQ.add(new Calc(i + 1, a, b));
            }
            else {
                Calc top = calcQ.poll();
                calcQ.add(new Calc(top.index, a, b + top.weight));
                outQ.add(new Out(top.index, top.id, top.weight));
            }
        }
    }

    private static void solve() {
        while (!calcQ.isEmpty()) {
            Calc top = calcQ.poll();
            outQ.add(new Out(top.index, top.id, top.weight));
        }
        printQ();
    }

    private static void printQ() {
        while (!outQ.isEmpty()) {
            Out top = outQ.poll();
//            System.out.println(top.index + ", " + top.id + ", " + top.weight);
            answer += answerI * (long)top.id;
            answerI++;
        }
    }


    private static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

class Calc implements Comparable<Calc> {
    int index;
    int id;
    int weight;

    public Calc(int index, int id, int weight) {
        this.index = index;
        this.id = id;
        this.weight = weight;
    }

    @Override
    public int compareTo(Calc c) {
        if(weight == c.weight) {
            return index - c.index;
        }
        return weight - c.weight;
    }
}

class Out implements Comparable<Out> {
    int index;
    int id;
    int weight;

    public Out(int index, int id, int weight) {
        this.index = index;
        this.id = id;
        this.weight = weight;
    }

    @Override
    public int compareTo(Out o) {
        if(weight == o.weight) {
            return o.index - index;
        }
        return weight- o.weight;
    }
}