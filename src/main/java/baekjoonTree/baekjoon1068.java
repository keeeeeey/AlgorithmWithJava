package baekjoonTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int removeNode = Integer.parseInt(br.readLine());
        System.out.println(solution(N, arr, removeNode));
    }

    public static int solution(int N, int[] arr, int removeNode) {
        List<Integer>[] tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == -1) {
                root = i;  // 루트 노드 찾기
            } else {
                tree[arr[i]].add(i);  // 부모-자식 관계 설정
            }
        }

        // 삭제할 노드가 루트라면 더 이상 노드가 남지 않음
        if (removeNode == root) {
            return 0;
        }

        // 노드 삭제
        remove(removeNode, tree);

        // 남은 리프 노드의 수 계산
        return countLeafNodes(root, tree);
    }

    public static void remove(int removeNode, List<Integer>[] tree) {
        // 부모 노드의 자식 리스트에서 삭제
        for (List<Integer> children : tree) {
            children.remove(Integer.valueOf(removeNode));
        }

        // 해당 노드의 모든 자식도 삭제
        for (int child : tree[removeNode]) {
            remove(child, tree);
        }
    }

    public static int countLeafNodes(int node, List<Integer>[] tree) {
        if (tree[node].isEmpty()) {
            return 1;  // 자식이 없으면 리프 노드
        }

        int leafCount = 0;
        for (int child : tree[node]) {
            leafCount += countLeafNodes(child, tree);
        }
        return leafCount;
    }
}
