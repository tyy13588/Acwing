package Acwing._7贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _1235付账问题 {
    static Scanner sc = new Scanner(System.in);
    static int N = 500010;
    static int a[] = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        double s = sc.nextDouble();
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        Arrays.sort(a, 1, n + 1);//按钱数 从小到大排序

        double avg = s / n, res = 0;
        for (int i = 1; i <= n; i++) {
            double cur = s / (n - (i - 1));//当前元素 出的钱
            if (a[i] < cur) {
                cur = a[i];//当前元素出不起的话 就出a[i]所有即可
                res += (cur - avg) * (cur - avg);
                s -= cur;
            } else {//当前元素开始 都出的起剩余钱
                res += (cur - avg) * (cur - avg) * (n - i + 1);
                break;
            }
        }
        System.out.println(String.format("%.4f", Math.sqrt(res / n)));
    }
}
