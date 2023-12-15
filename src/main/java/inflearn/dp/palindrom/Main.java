package inflearn.dp.palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            hashMap.put(tmp, hashMap.getOrDefault(tmp, 0) + 1);
            deque.offerLast(tmp);
        }
        System.out.println(solution(N, hashMap, deque));
    }

    private static int solution(int N, HashMap<Integer, Integer> hashMap, Deque<Integer> deque) {
        if (N == 1) return 0;

        int answer = 0;
        while (deque.size() > 1) {
            int a = deque.peekFirst();
            int b = deque.peekLast();
            if (a == b) {
                deque.pollFirst();
                deque.pollLast();
            } else {
                answer += 1;
                if (hashMap.get(b) == 1) {
                    deque.pollLast();
                    hashMap.put(b, hashMap.get(b) - 1);
                    continue;
                }
                if (hashMap.get(a) % 2 == 1) {
                    deque.pollFirst();
                    hashMap.put(a, hashMap.get(a) - 1);
                } else {
                    deque.pollLast();
                    hashMap.put(b, hashMap.get(b) - 1);
                }
            }
        }
        return answer;
    }
}
