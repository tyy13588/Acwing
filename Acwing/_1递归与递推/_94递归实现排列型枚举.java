package Acwing._1递归与递推;

import java.io.*;


public class _94递归实现排列型枚举 {
    static int N = 10;
    static int n;
    static int state[] = new int[N];//记录状态数字
    static boolean used[] = new boolean[N];//记录数字 是否使用
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void dfs(int u) throws IOException {
        if (u > n) {//边界问题
            for (int i = 1; i <= n; i++)
                bw.write(state[i] + " ");
            bw.newLine();
            bw.flush();
            return;
        }
        //依次枚举每个分支 ，即当前位置可以填哪些数字
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                state[u] = i;
                used[i] = true;
                dfs(u + 1);

                //恢复
                state[u] = 0;//可省略
                used[i] = false;//不可省
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dfs(1);
        br.close();
        bw.close();
    }
}
