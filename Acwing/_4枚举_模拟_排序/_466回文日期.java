package Acwing._4枚举_模拟_排序;

import java.util.Scanner;

public class _466回文日期 {
    static Scanner sc = new Scanner(System.in);
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//月份表

    public static void main(String[] args) {
        int date1 = sc.nextInt();
        int date2 = sc.nextInt();
        int res = 0;
        for (int i = 1000; i <= 9999; i++) {
            int x = i, r = i;
            for (int j = 0; j < 4; j++) {// 1234 循环拼接4321  得到12344321
                x = x * 10 + r % 10;
                r /= 10;
            }
            //得到回文数 判断是否在给定范围 以及 判断日期是否合法
            if (date1 <= x && x <= date2 && check(x)) res++;
        }
        System.out.println(res);
    }

    //判断日期是否合法
    static boolean check(int date) {
        int year = date / 10000;
        int month = date / 100 % 100;
        int day = date % 100;
        //月份判定
        if (month == 0 || month > 12 || day == 0) return false;
        if (month != 2 && day > months[month]) return false;
        if (month == 2) {//2月
            boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
            if (leap)//闰年
                if (day > 30) return false;
                else {//非闰年
                    if (day > 29) return false;
                }
        }
        return true;
    }
}
