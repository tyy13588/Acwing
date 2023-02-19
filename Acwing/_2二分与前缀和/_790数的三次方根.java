package Acwing._2二分与前缀和;

import java.util.Scanner;

public class _790数的三次方根 {
    static double l = -10000, r = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (r - l > 1e-8) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= x) r = mid;
            else l = mid;
        }
        System.out.println(String.format("%.6f", l));
    }
}
