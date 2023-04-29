import java.util.Comparator;
import java.util.PriorityQueue;

class Static{
    public int a = 20;
    static int b = 0;
}
public class Main
{

    public static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (this.x == point.x) {
                return this.y - point.y;
            }
            return this.x - point.x;
        }

    }

    public static void main(String[] args) {
        int a;
        a = 10;
        Static.b = a;
        Static st = new Static();
        System.out.println(Static.b++);
        System.out.println(st.b);
        System.out.println(a);
        System.out.println(st.a);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        pq.offer(5);

        pq.removeIf(i -> (i % 2 == 0));

        for (Integer integer : pq) {
            System.out.println(integer);
        }
    }
}