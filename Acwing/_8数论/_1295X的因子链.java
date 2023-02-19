package Acwing._8数论;

import java.util.Scanner;

public class _1295X的因子链 {
    static int N = (1 << 20 + 10);
    static int primes[] = new int[N];//存所有质数
    static int cnt;
    static int minp[] = new int[N];//最小质因子
    static boolean st[] = new boolean[N];//判断是否 被筛

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        get_primes(N - 1);//晒出素数

        int fact[] = new int[30];//因子
        int sum[] = new int[N];//因子的个数
        int x = 0;
        while (sc.nextInt() != -1) {
            int k = 0;
            int tot = 0;
            while (x > 1) {
                int p = minp[x];
                fact[k] = p;
                sum[k] = 0;
                while (x % p == 0) {
                    x /= p;
                    sum[k]++;
                    tot++;
                }
                k++;
            }

            long res = 1;
            for (int i = 1; i <= tot; i++) res *= tot;
            for (int i = 0; i < k; i++) {
                for (int j = 1; j <= sum[i]; j++) res /= j;
            }
            System.out.println(res);
        }
    }


    public static void get_primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] * i <= n; j++) {
                int t = primes[j] * i;//筛掉t
                st[t] = true;
                minp[t] = primes[j];//存t的最小质因子
                if (i % primes[j] == 0) break;
            }
        }
    }
}
