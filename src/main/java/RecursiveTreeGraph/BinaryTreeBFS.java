package RecursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 lt, rt;
    public Node2(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BinaryTreeBFS {
    Node2 root;
    public void bfs(Node2 root) {
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(l + " : ");
            for (int i = 0; i < len; i++) {
                Node2 cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    q.offer(cur.rt);
                }
            }
            l++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeBFS btb = new BinaryTreeBFS();
        btb.root = new Node2(1);
        btb.root.lt = new Node2(2);
        btb.root.rt = new Node2(3);
        btb.root.lt.lt = new Node2(4);
        btb.root.lt.rt = new Node2(5);
        btb.root.rt.lt = new Node2(6);
        btb.root.rt.rt = new Node2(7);
        btb.bfs(btb.root);
    }
}
