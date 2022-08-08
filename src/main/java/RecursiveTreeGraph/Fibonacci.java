package RecursiveTreeGraph;

public class Fibonacci {
    static int[] fibo;
    public int dfs(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = dfs(n - 2) + dfs(n - 1);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 10;
        fibo = new int[n + 1];
        fibonacci.dfs(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
