package Acwing._3数学与简单DP;

import java.util.Scanner;

public class _1212地宫取宝 {
    static Scanner sc = new Scanner(System.in);
    static int MOD = 1000000007;

    public static void main(String[] args) {
        int n = sc.nextInt();//行
        int m = sc.nextInt();//列
        int k = sc.nextInt();//件数
        int w[][] = new int[n+1][m+1];//价值
        int dp[][][][] = new int[55][55][13][14];   //个数：0~12 价值-1~12 此处-1为了方便初始化起点（1，1）处选择不取时
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = sc.nextInt();
                w[i][j]++;//偏移量+1 价值-1~12 变为 0~13
            }
        }
        //两个边界初始化
        // 在起点 (1, 1) 处如果拿也只能拿 a[i][j] 这个物品，只有一种方案
        // 如果不拿，那就是 0 个物品，也是一个方案数由于物品价值已经增加了一个偏移量，现在价值的范围是 [1, 13]
        // 所以价值为 0 并不代表物品的价值，而是一个边界点
        dp[1][1][1][w[1][1]] = 1;//第一个 取
        dp[1][1][0][0] = 1;//不取

        //循环所有状态
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;//起点已经做过
                for (int u = 0; u <= k; u++) {
                    for (int v = 0; v <= 13; v++) {
                        // 不取物品
                        dp[i][j][u][v] = (dp[i][j][u][v]+dp[i-1][j][u][v])%MOD;
                        dp[i][j][u][v] = (dp[i][j][u][v]+dp[i][j-1][u][v])%MOD;//不能直接三个数 相加10^8+10^8+10^8可能会爆int(2.1*10^8)
                        //取
                        if (u>0 && v==w[i][j]){
                            for (int s = 0; s < v; s++) {//枚举c‘
                                dp[i][j][u][v]=(dp[i][j][u][v]+dp[i-1][j][u-1][s])%MOD;
                                dp[i][j][u][v]=(dp[i][j][u][v]+dp[i][j-1][u-1][s])%MOD;
                            }
                        }
                    }
                }
            }
        }
        int res=0;
        for (int i = 0; i <=13 ; i++)
            res=(res+dp[n][m][k][i])%MOD;
        System.out.println(res);
    }
}
