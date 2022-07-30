package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ReversePrime {
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int res = 0;
            while (temp > 0) {
                int t = temp % 10;
                res = res * 10 + t;
                temp = temp / 10;
            }
            if (isPrime(res)) {
                answer.add(res);
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        ReversePrime rp = new ReversePrime();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : rp.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
