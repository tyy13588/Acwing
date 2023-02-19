package Acwing._2二分与前缀和;

import java.util.Scanner;

public class _795前缀和 {
    static Scanner sc = new Scanner(System.in);
    static int a[] = new int[100010];//原数组
    static int s[] = new int[100010];//前缀和数组

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
        }
        //循环m次查询
        while (m-- >= 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(s[r] - s[l-1]);
        }
    }
}
