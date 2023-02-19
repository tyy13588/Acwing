package Acwing._3数学与简单DP;

import java.util.Scanner;

public class _1015摘花生 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();//T组数据
        int r, c;// 行 列
        int w[][] = new int[110][110];//花生数量
        while (true) {
            r = sc.nextInt();
            c = sc.nextInt();
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    w[i][j] = sc.nextInt();
                }
            }
            int dp[][] = new int[r + 1][c + 1];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + w[i][j], dp[i][j - 1] + w[i][j]);
                }
            }
            System.out.println(dp[r][c]);
            if (!(--T > 0))return;//循环T组数据
        }
    }
}
