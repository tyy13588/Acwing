package Acwing._4枚举_模拟_排序;

import java.util.Arrays;
import java.util.Scanner;

public class _1210连号区间 {
    static Scanner sc = new Scanner(System.in);
    static int Max, Min;

    public static void main(String[] args) {
        int N = sc.nextInt();
        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        int res = 0;
        for (int i = 1; i <= N; i++) {//枚举左端点
            Max = Integer.MIN_VALUE;
            Min = Integer.MAX_VALUE;
            for (int j = i; j <= N; j++) {//枚举右端点
                Max = Math.max(Max, arr[j]);
                Min = Math.min(Min, arr[j]);
                if (j - i + 1 == Max - Min + 1) res++;
            }
        }
        System.out.println(res);
    }
}


