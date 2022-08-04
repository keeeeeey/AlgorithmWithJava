package RecursiveTreeGraph;

public class BinaryNumberRecursion {
    public void dfs(int n) {
        if (n == 0) {
            return;
        } else {
            dfs(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

    public static void main(String[] args) {
        BinaryNumberRecursion bnr = new BinaryNumberRecursion();
        bnr.dfs(11);
    }
}
