package baekjoonPq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑 {

    public static int N, K;
    public static PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
    public static List<Integer> bagList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelries.offer(new Jewelry(weight, price));
        }

        for (int i = 0; i < K; i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }
        bagList.sort(Comparator.comparingInt(a -> a));
    }

    private static long solve() {
        long answer = 0;
        while (!jewelries.isEmpty() && !bagList.isEmpty()) {
            Jewelry jewelry = jewelries.poll();
            int bagIdx = binarySearch(jewelry.weight);
            if (bagList.get(bagIdx) >= jewelry.weight) {
                answer += jewelry.price;
                bagList.remove(bagIdx);
            }
        }
        return answer;
    }

    private static int binarySearch(int weight) {
        int left = 0;
        int right = bagList.size() - 1;
        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bagList.get(mid) < weight) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}

class Jewelry implements Comparable<Jewelry> {
    int weight;
    int price;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewelry target) {
        return target.price - this.price;
    }
}