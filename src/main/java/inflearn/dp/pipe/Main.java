package inflearn.dp.pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] dy = new int[D + 1];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            for (int j = D; j > L; j--) {
                if (dy[j - L] == 0) continue;
                dy[j] = Math.max(dy[j], Math.min(dy[j - L], C));
            }
            dy[L] = Math.max(dy[L], C);
        }
        System.out.println(dy[D]);
    }
}
