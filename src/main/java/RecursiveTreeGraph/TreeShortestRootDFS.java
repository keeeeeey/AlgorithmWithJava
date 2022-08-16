package RecursiveTreeGraph;

class Node3 {
    int data;
    Node3 lt, rt;
    public Node3(int val) {
        data = val;
        lt = rt = null;
    }
}

public class TreeShortestRootDFS {
    Node3 root;
    public int dfs(int l, Node3 root) {
        if (root.lt == null && root.rt == null) {
            return l;
        } else {
            return Math.min(dfs(l + 1, root.lt), dfs(l + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        TreeShortestRootDFS tsrd = new TreeShortestRootDFS();
        tsrd.root = new Node3(1);
        tsrd.root.lt = new Node3(2);
        tsrd.root.rt = new Node3(3);
        tsrd.root.lt.lt = new Node3(4);
        tsrd.root.lt.rt = new Node3(5);
        System.out.println(tsrd.dfs(0, tsrd.root));
    }
}
