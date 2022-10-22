import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int solution(String str) {
        String original = "";
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                original += str.charAt(i);
            }
        }
        int answer = Integer.parseInt(original);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(m.solution(str));
    }

}
