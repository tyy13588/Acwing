package Acwing._2二分与前缀和;

import java.io.IOException;
import java.util.Scanner;

public class _1227分巧克力 {
    static Scanner sc = new Scanner(System.in);
    static int w[] = new int[100010];
    static int h[] = new int[100010];
    static int n, k;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        //二分遍历符合条件的 x（最大边长）
        int l = 1, r = 100000;//最小1*1
        while (l < r) {
            int mid = l + r + 1 >> 1;
            //判断此时 mid边长 是否符合
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(l);
    }

    private static boolean check(int mid) {
        int res = 0;
        //枚举 n块巧克力 是否够 k 块
        for (int i = 0; i < n; i++) {
            // h * w 的巧克力 可以分成边长为 mid 的块数
            res += (h[i] / mid) * (w[i] / mid);
            //够分
            if (res >= k) return true;
        }
        return false;
    }
}
