package Acwing._7贪心;

import java.util.Scanner;

public class _1055股票买卖Ⅱ {
    static int N = 100010;
    static Scanner sc = new Scanner(System.in);
    static int[][] f = new int[N][2];
    static int[] price = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        f[0][1]=Integer.MIN_VALUE;// 注意需要初始化
        //因为f[0][1]代表考虑前 0天，状态是已经买入，这是一个不合法状态。第一次买入至少是在第 1天
        //如果不把它初始化为负无穷，f[1][0]就会更新成f[0][1] + w[1]，也就是w[1]但是f[1][0]实际意义是第 1天不买入股票，那么收益就是 0，而不是w[i]
        for (int i = 1; i <= n; i++) price[i] = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + price[i]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - price[i]);
        }
        System.out.println(f[n][0]);
    }
}
