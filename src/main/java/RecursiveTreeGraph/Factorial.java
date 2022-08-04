package RecursiveTreeGraph;

public class Factorial {
    public int dfs(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * dfs(n - 1);
        }
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.dfs(5));
    }
}
