package Acwing._9DP;

import java.util.Scanner;

public class _897最长公共子序列 {
    public static final int N1 = 1010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        char[] a = sc.nextLine().toCharArray();
        char[] b = sc.nextLine().toCharArray();

        int dp[][] = new int[N1][N1];
        for (int i = 1; i <= N; i++) {//从1开始 因为会用到i-1
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]) + 1;
            }
        }
        System.out.println(dp[N][M]);
    }
}
