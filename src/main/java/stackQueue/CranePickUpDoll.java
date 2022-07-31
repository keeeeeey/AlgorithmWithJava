package stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class CranePickUpDoll {
    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < n; i++) {
                if (board[i][moves[k] - 1] != 0) {
                    int temp = board[i][moves[k] - 1];
                    board[i][moves[k] - 1] = 0;
                    if (!stack.isEmpty() && temp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(temp);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CranePickUpDoll cpud = new CranePickUpDoll();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(cpud.solution(n, board, m, moves));
    }
}
