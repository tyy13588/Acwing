package Acwing._4枚举_模拟_排序;

import java.util.Scanner;

public class _1219移动距离 {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int w=sc.nextInt();
        int m=sc.nextInt();m--;// 减一为了使得索引下标从 0开始 便于求 行 列
        int n=sc.nextInt();n--;

        int x1=m/w,x2=n/w;// m n的行
        int y1=m%w,y2=n%w;//列

        if (x1%2==1) y1=w-1-y1;//回型需要处理 奇数行的情况
        if (x2%2==1) y2=w-1-y2;

        System.out.println(Math.abs(x1-x2)+Math.abs(y1-y2));
    }
}
