package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Maze1 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int x, int y, int[][] maze) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        maze[x][y] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16 && maze[nx][ny] != 1) {
                    if (maze[nx][ny] == 3) {
                        return 1;
                    }
                    q.offer(new Point(nx, ny));
                    maze[nx][ny] = 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Maze1 m = new Maze1();
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int tc = sc.nextInt();
            int[][] maze = new int[16][16];
            for (int i = 0; i < 16; i++) {
                String row = sc.next();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = Character.getNumericValue(row.charAt(j));
                }
            }

            int si = 0, sj = 0;
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (maze[i][j] == 2) {
                        si = i;
                        sj = j;
                    }
                }
            }
            System.out.print("#" + tc + " ");
            System.out.println(m.solution(si, sj, maze));
        }
    }
}
