package Acwing._7贪心;

import java.util.Scanner;

public class _1055股票买卖Ⅱ贪心 {
    static int N = 100010;
    static Scanner sc = new Scanner(System.in);
    static int[] price = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int res=0;
        for(int i=1;i<=n;i++) price[i]=sc.nextInt();
        for (int i = 1; i + 1 <= n; i++) {
            int profit = price[i + 1] - price[i];
            if (profit>0) res+=profit;
        }
        System.out.println(res);
    }
}
