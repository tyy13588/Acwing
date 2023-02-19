package Acwing._3数学与简单DP;

/**
 * //裴蜀定理的应用
 */

import java.util.Scanner;

public class _1205买不到的数目 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println((n - 1) * (m - 1) - 1);//裴蜀定理
    }
}
