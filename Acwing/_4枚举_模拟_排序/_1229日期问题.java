package Acwing._4枚举_模拟_排序;

import java.util.Scanner;

public class _1229日期问题 {
    static Scanner sc = new Scanner(System.in);
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//月份表

    public static void main(String[] args) {
        String[] s = sc.nextLine().split("/");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        for (int date = 19600101; date <= 20591231; date++) {
            int year = date / 10000;
            int month = date / 100 % 100;
            int day = date % 100;
            if (check(year, month, day)) {
                if (year % 100 == a && month == b && day == c ||// 年月日
                        month == a && day == b && year % 100 == c ||  //月 日 年
                        day == b && month == b && year %100== c//日 月 年
                ) {
                    System.out.print(year+"-");
                    if (month<10) System.out.print("0");
                    System.out.print(month+"-");
                    if (day<10) System.out.print("0");
                    System.out.println(day);
                }
            }

        }
    }

    //判断给定日期是否合法
    static boolean check(int year, int month, int day) {
        if (month == 0 || month > 12 || day == 0) return false;
        if (month != 2 && day > months[month]) return false;
        if (month == 2) {
            boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
            if (leap) {
                if (day > 29) return false;
            } else if (day > 28) return false;
        }
        return true;
    }
}
