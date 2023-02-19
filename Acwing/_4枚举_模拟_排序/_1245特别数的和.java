package Acwing._4枚举_模拟_排序;

import java.util.Scanner;

public class _1245特别数的和 {
    static Scanner sc = new Scanner(System.in);
    static int res = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++)
            if (check(i)) res += i;
        //if (check1(i)) res += i;

        System.out.println(res);
    }

    static boolean check(int num) {
        String s = String.valueOf(num);
        if (s.contains("2")) return true;
        if (s.contains("0")) return true;
        if (s.contains("1")) return true;
        if (s.contains("9")) return true;
        return false;
    }

    static boolean check1(int num) {
        while (num > 0) {
            int t = num % 10;
            num = num / 10;
            if (t == 2 || t == 0 || t == 1 || t == 9) {
                return true;
            }
        }
        return false;
    }
}
