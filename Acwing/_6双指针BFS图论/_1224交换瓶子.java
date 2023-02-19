package Acwing._6双指针BFS图论;

import java.util.Scanner;

public class _1224交换瓶子 {
    static int N = 10010;
    static Scanner sc = new Scanner(System.in);
    static int bottle[] = new int[N];
    static boolean st[] = new boolean[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++)
            bottle[i] = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!st[i]){
                cnt++;
                //标记所有可到的点
                for (int j = i; !st[j] ; j=bottle[j]) st[j]=true;
            }
        }
        System.out.println(n-cnt);
    }
}
