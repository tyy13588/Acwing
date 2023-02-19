package Acwing._1递归与递推;

import java.io.*;

public class _93递归实现组合型枚举 {
    static int N = 30;
    static int n, m;
    static int way[] = new int[N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void dfs(int u, int start) throws IOException {
        if (u + n - start < m) return;
        if (u == m + 1) {
            for (int i = 1; i <= m; i++) {
                pw.print(way[i]+" ");
                pw.flush();
            }
            pw.println();
            pw.flush();
        }
        for (int i = start; i <= n; i++) {
            way[u] = i;
            dfs(u + 1, i + 1);
            way[u] = 0;//恢复
        }
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dfs(1, 1);
        br.close();
        pw.close();
    }
}
