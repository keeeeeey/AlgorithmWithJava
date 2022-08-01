package sortingAndSearching;

import java.util.Scanner;

public class BubbleSort {
    public int[] solution(int n, int[] arr) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : bs.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
