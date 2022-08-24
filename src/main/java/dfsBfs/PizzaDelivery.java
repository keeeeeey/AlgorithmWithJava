package dfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

class Point4 {
    public int x, y;
    Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class PizzaDelivery {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point4> hs, pz;

    public void dfs(int l, int s) {
        if (l == m) {
            int sum = 0;
            for (Point4 h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[l] = i;
                dfs(l + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        PizzaDelivery pd = new PizzaDelivery();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                if (temp == 1) {
                    hs.add(new Point4(i, j));
                } else if (temp == 2) {
                    pz.add(new Point4(i, j));
                }
            }
        }
        len = pz.size();
        combi = new int[m];
        pd.dfs(0, 0);
        System.out.println(answer);
    }
}
