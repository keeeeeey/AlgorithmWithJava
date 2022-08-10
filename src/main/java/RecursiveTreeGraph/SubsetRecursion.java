package RecursiveTreeGraph;

public class SubsetRecursion {
    static int n;
    static int[] ch;
    public void dfs(int L) {
        if (L == n + 1) {
            String temp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    temp += i + " ";
                }
            }
            if (temp.length() > 0) {
                System.out.println(temp);
            }
        } else {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) {
        SubsetRecursion sr = new SubsetRecursion();
        n = 3;
        ch = new int[n + 1];
        sr.dfs(1);
    }
}
