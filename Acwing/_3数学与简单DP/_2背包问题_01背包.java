package Acwing._3数学与简单DP;

import java.util.Scanner;

public class _2背包问题_01背包 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int V = sc.nextInt();
        int v[] = new int[1010];
        int w[] = new int[1010];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int dp[][] = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - v[i]] + w[i], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[N][V]);
    }
}
