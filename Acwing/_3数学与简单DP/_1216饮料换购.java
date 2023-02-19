package Acwing._3数学与简单DP;

import java.util.Scanner;

public class _1216饮料换购 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int res = n;
        while (n >= 3) {
            res += n / 3;//瓶子数量
            n = n / 3 + n % 3;//盖子数量
        }
        System.out.println(res);
    }
}
