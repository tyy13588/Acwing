package Acwing._9DP;

import java.util.Scanner;

public class _282石子合并 {
    static final int N = 310;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s[] = new int[N];
        int f[][] = new int[N][N];
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            s[i] += s[i - 1];
        }

        //枚举长度
        for (int len = 2; len <= n; len++) {
            //枚举起点
            for (int i = 1; i + len - 1 <= n; i++) {
                int left = i, right = i + len - 1;
                f[left][right]=Integer.MAX_VALUE;
                for (int k = left; k < right; k++) {
                    f[left][right] = Math.min(f[left][right], f[left][k] + f[k + 1][right] + s[right] - s[left - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
//
//        //	区间dp枚举套路：长度+左端点
//        for (int len = 2; len <= n; len++) {
//            for (int i = 1; i + len - 1 <= n; i++) {
//                int left = i, right = i + len - 1;
//                f[left][right] = Integer.MAX_VALUE;
//                for (int k = left; k < right; k++) {
//                    //s(j)−s(i−1):表示合并f(i,k)和f(k+1,j)的代价
//                    f[left][right] = Math.min(f[left][right], f[left][k] + f[k + 1][right] + s[right] - s[left - 1]);
//                }
//            }
//        }

        System.out.println(f[1][n]);
    }
}
