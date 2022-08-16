package RecursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

class Node4 {
    int data;
    Node4 lt, rt;
    public Node4(int val) {
        data = val;
        lt = rt = null;
    }
}

public class TreeShortestRootBFS {
    Node4 root;
    public int bfs(Node4 root) {
        Queue<Node4> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node4 cur = q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return l;
                }
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            l++;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeShortestRootBFS tsrb = new TreeShortestRootBFS();
        tsrb.root = new Node4(1);
        tsrb.root.lt = new Node4(2);
        tsrb.root.rt = new Node4(3);
        tsrb.root.lt.lt = new Node4(4);
        tsrb.root.lt.rt = new Node4(5);
        System.out.println(tsrb.bfs(tsrb.root));
    }
}
