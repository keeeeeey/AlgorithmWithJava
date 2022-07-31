package HashMapTreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class KthLargestNumber {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;

        // 특정 값을 TreeSet에서 삭제
        tSet.remove(143);

        // tSet 원소가 몇개인지 리턴
        System.out.println(tSet.size());

        // 오름차순일때는 최소값, 내림차순일때는 최대값 리턴
        System.out.println(tSet.first());

        // 오름차순일때는 최대값, 내림차순일때는 최소값 리턴
        System.out.println(tSet.last());

        for (int x : tSet) {
            System.out.println(x);
            cnt++;
            if (cnt == k) {
                return x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        KthLargestNumber kln = new KthLargestNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(kln.solution(n, k, arr));
    }
}
