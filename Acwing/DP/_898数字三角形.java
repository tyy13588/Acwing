package Acwing.DP;

import java.util.Scanner;

public class _898数字三角形 {
    static int N=510;
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int INF=-(int)(1.0/0.0);
            //多开2个为边界填充负无穷
            int f[][] = new int[N][N];
            int a[][] = new int[N][N];
            //录入数据
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= i; j++)
                    a[i][j] = sc.nextInt();
            //初始化f[][]  负无穷
            for (int i = 0; i <= n; i++)
                for (int j = 0; j <= i + 1; j++)
                    f[i][j] = INF;

            f[1][1] = a[1][1];
            for (int i = 2; i <= n; i++)
                for (int j = 1; j <= i; j++)
                    f[i][j] = Math.max(f[i - 1][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
            //比较每行最大的一个
            int res = INF;
            for (int i = 1; i <= n; i++){
                res = Math.max(res, f[n][i]);
            }
           System.out.println(res);
            return;
        }


    }
}
