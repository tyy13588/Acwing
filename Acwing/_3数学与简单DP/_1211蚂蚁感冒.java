package Acwing._3数学与简单DP;

import java.util.Scanner;

import static java.lang.Math.abs;

public class _1211蚂蚁感冒 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();// a[i]   +:向右    -:向左
        //   左向右           右向左 蚂蚁的数量
        int leftToRight = 0, rightToLeft = 0;
        for (int i = 0; i < n; i++) {
            //如果在感冒蚂蚁的左边 且 方向向左
            if (abs(a[i]) < abs(a[0]) && a[i] > 0) leftToRight++;
            //如果在感冒蚂蚁的右边 且 方向向左
            else if (abs(a[0]) < abs(a[i]) && a[i] < 0) rightToLeft++;
        }

        //判断是否存在 感冒蚂蚁右 且有右向左的蚂蚁   冒蚂蚁向左 且有左向右的蚂蚁
        if ((a[0] > 0 && rightToLeft > 0) || (a[0] < 0 && leftToRight > 0)) {
            System.out.println(leftToRight + rightToLeft + 1);
        } else
            System.out.println(1);//本身感染
    }
}
