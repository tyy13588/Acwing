package Acwing._2二分与前缀和;

import java.util.Scanner;

public class _99激光炸弹 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();//目标数
        int R = Math.min(5001, sc.nextInt());//半径
        int s[][] = new int[5010][5010];
        while (N-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            s[++x][++y] += w;//++x来处理数据由0开始  转为1开始
        }
        //二维前缀和数组
        for (int i = 1; i <= 5001; i++)
            for (int j = 1; j <= 5001; j++)
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + s[i][j];
        //求边长为R的正方形得到的最大值
        int res = 0;
        for (int i = R; i <= 5001; i++)
            for (int j = R; j <= 5001; j++)
                //枚举子矩阵 右下角 （i，j）
                res = Math.max(res, s[i][j] - s[i - R][j] - s[i][j - R] + s[i - R][j - R]);
        System.out.println(res);
    }
}
