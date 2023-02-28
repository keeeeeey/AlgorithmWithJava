package baekjoonGraph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
public class AdjacencyMatrix {

    public static StringTokenizer st;
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());    // 노드의 수
        int E = Integer.parseInt(st.nextToken());    // 간선의 수

        // 노드의 수만큼 리스트 추가
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 시작 노드
            int e = Integer.parseInt(st.nextToken());   // 끝 노드
            graph.get(s).add(e);
        }

        System.out.println(graph);
    }
}
