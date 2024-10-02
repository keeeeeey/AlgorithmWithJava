import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aurum_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cardCnt = 54;
        float answer = calculatePercent(N, cardCnt);
        System.out.println(answer);
    }

    public static float calculatePercent(int N, int cardCnt) {

        if (N > 14) return 0;

        float answer = 1;
        int leftCardCnt = 14;
        int totalCardCnt = 54;
        for (int i = 1; i < N; i++) {
            leftCardCnt -= 1;
            totalCardCnt -= 1;
            answer = answer * leftCardCnt / totalCardCnt;
        }
        return answer;
    }
}
