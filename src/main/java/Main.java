import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxNumber = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 0; i < 9; i++) {
            if (maxNumber < arr[i]) {
                maxNumber = arr[i];
                idx = i + 1;
            }
        }

        System.out.println(maxNumber);
        System.out.println(idx);
    }

}
