package Acwing._7贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _122糖果传递 {
    static Scanner sc = new Scanner(System.in);
    static int N = 1000010;
    static int[] a = new int[N];
    static int[] c = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        long aSum = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            aSum += a[i];
        }
        int ave =(int) (aSum / n);
        c[1] = 0;//初始化
        for (int i = 2; i <= n; i++) c[i] = a[i] + c[i - 1] - ave;//记录 c数组

        //找到 c数组中间点
        Arrays.sort(c, 1, n + 1);
        int mid = c[(n + 1) / 2];
        //求和
        long sum = 0;
        for (int i = 1; i <= n; i++) sum += Math.abs(c[i] - mid);
        System.out.println(sum);
    }
}
