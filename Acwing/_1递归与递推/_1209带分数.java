package Acwing._1递归与递推;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class _1209带分数 {
    static int N = 10, n, ans;// n:输入数字 ans：最终符合答案的数量
    static boolean st[] = new boolean[N];//是否已经使用过数组

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    static void dfs_a(int u, int a) {
        if (a >= n) return;//如果当前的a 大于等于输入的n 则返回（带分数的整数部分大于等于输入的数字）
        // if (a) dfs_c(u,a,0);
        for (int i = 1; i <= 9; i++) {
            if (!st[i]) {
                st[i] = true;
                dfs_a(u + 1, a * 10 + i);
                st[i] = false;
            }

        }
    }

    private static void dfs_c(int u, int a, int c) {
        if (u > 9) return;//如果9个数字全部使用 则直接输出
        if (check(a, c)) ans++;
        for (int i = 1; i <= 9; i++) {
            if (!st[i]) {
                st[i] = true;
                dfs_c(u + 1, a, c * 10 + i);//如果这个数没有勇敢 就把它放在c后面 dfs的下一层
                st[i] = false;
            }

        }
    }

    private static boolean check(int a, int c) {//检查  a,b,c 三个参数是否符合题意
        return true;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dfs_a(0, 0);//第一个0 表示用了多少个数字，第二个0表示当前的a为多少
        pw.println(ans);
        pw.close();
        br.close();
    }
}
