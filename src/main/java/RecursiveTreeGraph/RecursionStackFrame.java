package RecursiveTreeGraph;

public class RecursionStackFrame {
    public void dfs(int n) {
        if (n == 0) {
            return;
        } else {
            dfs(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        RecursionStackFrame rsf = new RecursionStackFrame();
        rsf.dfs(3);
    }
}
