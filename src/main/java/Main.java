import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(int n, int[] arr) {
        int answer = 0;
        int stone = -1;
        while (true) {
            if (stone + 3 > n - 1) {
                break;
            }

            int nextStone = 0;
            int minPoison = 1000;
            for (int i = stone + 1; i <= stone + 3; i++) {
                if (arr[i] <= minPoison) {
                    nextStone = i;
                    minPoison = arr[i];
                }
            }
            stone = nextStone;
            answer += minPoison;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr));
    }
}