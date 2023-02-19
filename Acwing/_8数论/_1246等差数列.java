package Acwing._8数论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * gcd  最大公约数
 */
public class _1246等差数列 {
    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static int a[] = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        Arrays.sort(a, 1, n + 1);
        int d = 0;
        //通过 最大公约数 求出 公差d
        for (int i = 2; i <= n ; i++) d = gcd( a[i] - a[1],d);

        if (d == 0) System.out.println(n);
        else System.out.println((a[n] - a[1]) / d + 1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
