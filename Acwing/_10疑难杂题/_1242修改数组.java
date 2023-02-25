package Acwing._10疑难杂题;

import java.util.Scanner;

public class _1242修改数组 {
    static Scanner sc = new Scanner(System.in);
    static int N = 1100010;
    static int p[] = new int[N];

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 1; i < N; i++) p[i] = i;//初始化 并查集
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            x = find(x);//找到 从 x 开始 第一个 没有被用过的数字
            System.out.print(x);
            p[x] = x + 1;//更新
        }
    }
}
