import java.util.*;

public class Test20240325 {

    public static List<Integer> xList = new ArrayList<>();

    public static List<Integer> sumList = new ArrayList<>();

    public static void main(String[] args) {
        xList.add(1);
        xList.add(1);
        sumList.add(1);
        sumList.add(2);
        int idx = 2;
        while (true) {
            int temp = xList.get(idx - 1) + xList.get(idx - 2);
            if (temp < 1000) {
                xList.add(temp);
                sumList.add(temp + sumList.get(idx - 1));
                idx += 1;
            } else {
                break;
            }
        }
        System.out.println(xList.get(xList.size() - 1));
        System.out.println(sumList.get(sumList.size() - 1));
    }
}
