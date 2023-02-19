package Acwing._7贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _1239乘积最大 {
    static Scanner sc = new Scanner(System.in);

    static int MOD = 1000000009;
    static int N = 100010;
    static int[] a = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

        //排序
        Arrays.sort(a, 1, n + 1);
        int res = 1, sign = 1;
        //双指针
        int l = 1, r = n;
        if (k % 2 == 1) {//k 是 奇数
            res = a[r--];//取出最大元素
            k--;
            //若是最大的一个数是负数，表示全部都是负数情况
            if (res < 0) sign = -1;
        }

        //处理k为 偶数的情况
        while (k > 0) {
            long x = (long) a[l] * a[l + 1], y = (long) a[r] * a[r - 1];
            if (y * sign > x * sign) {//右边大
                res = (int) (y % MOD * res % MOD);
                r -= 2;
            } else {//左边大
                res = (int) (x % MOD * res % MOD);
                l += 2;
            }
            k -= 2;
        }
        System.out.println(res);
    }
}
