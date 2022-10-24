import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public int solution(int[] arr, int n) {
        int answer = 1;
        int maxH = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxH) {
                answer += 1;
                maxH = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(m.solution(arr, n));
//        for (int num : m.solution(arr, n)) {
//            System.out.print(num + " ");
//        }
    }

}
