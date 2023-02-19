package Acwing._2二分与前缀和;

import java.util.Scanner;

public class _1230K倍区间 {
    static Scanner sc = new Scanner(System.in);
    static long s[] = new long[100010];// 前缀和数组 要开成long 防止爆int
    static int[] cnt = new int[100010];//存每个余数的个数数组

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++)
            s[i] = s[i - 1] + sc.nextInt();//处理二维前缀和数组

        long res = 0;
        cnt[0] = 1;// cnt[0]中存的是s[]中等于0的数的个数 由于s[0] = 0 所以最初等于0的有1个数 所以cnt[0] = 1
        for (int r = 1; r <= N; r++) {
            res += cnt[(int) (s[r] % K)];
            cnt[(int) (s[r] % K)]++;// 记录序列%k不同余数的个数
        }
        System.out.println(res);
    }
}
