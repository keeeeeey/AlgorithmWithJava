package RecursiveTreeGraph;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class BinaryTreeRecursion {
    Node root;
    public void dfs(Node root) {
        if (root == null) {
            return;
        } else {
            dfs(root.lt);
            dfs(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeRecursion bnr = new BinaryTreeRecursion();
        bnr.root = new Node(1);
        bnr.root.lt = new Node(2);
        bnr.root.rt = new Node(3);
        bnr.root.lt.lt = new Node(4);
        bnr.root.lt.rt = new Node(5);
        bnr.root.rt.lt = new Node(6);
        bnr.root.rt.rt = new Node(7);
        bnr.dfs(bnr.root);

    }
}
