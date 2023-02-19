package Acwing._7贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _1247后缀表达式 {
    static Scanner sc = new Scanner(System.in);
    static int a[] = new int[200010];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = n + m + 1;
        for (int i = 1; i <= k; i++) a[i] = sc.nextInt();

        long res = 0;
        if (m == 0) {//没有减号
            for (int i = 1; i <= k; i++) res += a[i];
        } else {
            Arrays.sort(a, 1, k + 1);//从小到大排序
            res = a[k] - a[1];
            for (int i = 2; i <= k - 1; i++) res += Math.abs(a[i]);
        }
        System.out.println(res);
        return;
    }
}
