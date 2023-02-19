package Acwing._1递归与递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class _92递归实现指数型枚举 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static int N = 15, n;
    static int st[] = new int[N];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dfs(0);
        pw.flush();
        pw.close();
        br.close();
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++)
                if (st[i] == 1)
                    pw.print(i + 1 + " ");
            pw.println();
            return;
        }
        st[u] = -1;  //不选
        dfs(u + 1);
        st[u] = 0;//父节点恢复状态

        st[u] = 1;//选
        dfs(u + 1);
        st[u] = 0;
    }
}
