package Acwing._3数学与简单DP;

import java.util.Scanner;

public class _1214波动数列 {
    static Scanner sc = new Scanner(System.in);
    static int MOD = 100000007;
    static int dp[][] = new int[1010][1010];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int s = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        //初始化
        dp[0][0] = 1;
        //枚举所有状态
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = (dp[i - 1][get_mod(j-(n-i)*a,n)] + dp[i - 1][get_mod(j+(n-i)*b,n)]) % MOD;

        System.out.println(dp[n - 1][s % n]);
    }

    static int get_mod(int a, int b) {//求 a除以b的正余数
        return (a % b + b) % b;
    }
}
