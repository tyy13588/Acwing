package Acwing._4枚举_模拟_排序;

import java.util.Scanner;

public class _1237螺旋折线 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long x = sc.nextInt(), y = sc.nextInt();//防止下面 k*k爆 int
        long k = Math.max(Math.abs(x), Math.abs(y));
        if (x >= y) System.out.println(4 * k * k + Math.abs(x - k) + Math.abs(y - k));//y=x 之下
        else System.out.println(4 * k * k - Math.abs(x - k) - Math.abs(y - k));//y=x 之上
    }

//    public static void main(String[] args) {
//        long x = sc.nextInt();
//        long y = sc.nextInt();
//
//        if (Math.abs(x) <= y) {//在上方
//            long n = y;
//            System.out.println((long) (2 * n - 1) * (2 * n) + x - (-n));  // 特殊点为起点 加 偏移量
//        } else if (Math.abs(y) <= x) {  // 在右方
//            long n = x;
//            System.out.println((long) (2 * n) * (2 * n) + n - y);
//        } else if (Math.abs(x) <= Math.abs(y) + 1 && y < 0) { //在下方
//            long n = Math.abs(y);
//            System.out.println((long) (2 * n) * (2 * n + 1) + n - x);
//        } else {  // 作左方
//            long n = Math.abs(x);
//            System.out.println((long) (2 * n - 1) * (2 * n - 1) + y - (-n + 1));
//        }
//    }
}
