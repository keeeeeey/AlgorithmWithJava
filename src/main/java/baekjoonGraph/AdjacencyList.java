package baekjoonGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 7
1 2
1 3
1 4
2 3
2 5
3 4
4 5
*/
public class AdjacencyList {

    public static StringTokenizer st;
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new int[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = 1;
        }

        for (int[] ints : graph) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
