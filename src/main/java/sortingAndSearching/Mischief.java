package sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mischief {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] temp = arr.clone(); // 깊은 복사
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Mischief mc = new Mischief();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : mc.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
