package Acwing._8数论;

public class _线性筛素数 {

    static int N = 100010;
    static int primes[] = new int[N];//存所有质数
    static int cnt;
    static boolean st[] = new boolean[N];

    public static void main(String[] args) {
        get_primes(100);
        for (int i = 0; i < 20; i++) System.out.println(primes[i]);
    }

    public static void get_primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] * i < n; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }
}
