package Acwing._7贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _104货仓选址 {
    static int N = 100010;
    static int[] x = new int[N];
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) x[i] = sc.nextInt();
        Arrays.sort(x, 1, n + 1);
        int mid = 0;
        if (n % 2 == 0) mid =  x[(n + 1)/2] ;
        else mid = x[n / 2];
        long res = 0;
        for (int i = 1; i <= n; i++) res += Math.abs(x[i] - x[mid]);
        System.out.println(res);
    }
}