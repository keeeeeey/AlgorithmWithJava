package study.divide.baekjoon_18114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hashMap.put(arr[i], 1);
        }
        Arrays.sort(arr);

        System.out.println(solution(N, C, arr, hashMap));
    }

    private static int solution(int N, int C, int[] arr, HashMap<Integer, Integer> hashMap) {

        for (int i = 0; i < N; i++) {
            if (arr[i] == C) {
                return 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (hashMap.containsKey(C - arr[i]) && C - arr[i] != arr[i]) {
                return 1;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (hashMap.containsKey(C - arr[i] - arr[j]) && C - arr[i] - arr[j] != arr[i] && C - arr[i] - arr[j] != arr[j]) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
