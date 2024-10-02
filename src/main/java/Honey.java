import java.util.ArrayList;
import java.util.List;

public class Honey {
    public static int[] solution(int n) {
        // 육각형 벌집의 크기와 각 변의 길이 계산
        int size = 1;
        int count = 1;
        while (size < n) {
            size += 6 * count;
            count++;
        }

        // 육각형 벌집을 달팽이 모양으로 순회하며 숫자 채우기
        int[] honeycomb = new int[10000];  // 숫자가 채워질 배열
        int[][] direction = {{1, 0}, {0, 1}, {-1, -1}};  // 각 방향으로 이동하기 위한 좌표 변화
        int x = 0, y = 0;  // 현재 위치
        int num = 1;  // 채워질 숫자

        for (int i = 1; i <= n; i++) {  // n까지의 육각형을 순회
            for (int j = 0; j < i; j++) {  // 한 변의 길이만큼 숫자를 채웁니다.
                honeycomb[x] = num;
                num++;
                // 다음 위치 계산
                int[] delta = direction[(i - 1) % 3];
                x += delta[0];
                y += delta[1];
            }
        }

        // 0이 아닌 숫자들을 배열에 담아 반환합니다.
        List<Integer> result = new ArrayList<>();
        for (int honey : honeycomb) {
            if (honey != 0) {
                result.add(honey);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // 예시 입력에 대한 테스트
        int[] result1 = solution(2);


        int[] result2 = solution(3);

    }
}
