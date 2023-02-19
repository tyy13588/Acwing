package Acwing._6双指针BFS图论;

import java.util.Scanner;

public class _1240完全二叉树的权值 {
    static Scanner sc = new Scanner(System.in);
    static int a[] = new int[100010];

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        long max = Integer.MIN_VALUE;
        int depth=0;
        for (int d = 1, i = 1; i <= n; d++, i *= 2) {//d 深度 层数 i每一层的起点   循环每一层
            long sum = 0;//可能爆 int
            for (int j = i; j < i + (1<<(d-1)) && j <= n; j++) sum += a[j];//每层的权值和
            if (sum > max){
                max=sum;
                depth = d;
            }
        }
        System.out.println(depth);
    }
}
